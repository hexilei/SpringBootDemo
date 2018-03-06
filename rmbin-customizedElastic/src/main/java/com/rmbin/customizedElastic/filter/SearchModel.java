package com.rmbin.customizedElastic.filter;

import java.util.List;

public class SearchModel {
	
	private List<Parameter> parameters;
	
	public static class Builder
	{
		
		private SearchModel searchModel = new SearchModel();
		
		public Builder(List<Parameter> parameters)
		{
			searchModel.parameters = parameters;
		}
		
		public boolean validate() throws Exception
		{
			for(Parameter parameter:searchModel.parameters)
			{
				if(!Operator.validate(parameter.getOperator()))
					{
						throw new Exception("Operator for parameter " + parameter.getName() + " is invalid.");
					};
			}
			return true;
		}
		
		public String buildSyntax() throws Exception
		{
			validate();
			StringBuilder builder = new StringBuilder();
			for(Parameter param:searchModel.parameters)
			{
				String name = param.getName();
				String value = param.getValue();
				Operator operator = param.getOperator();
				builder.append(name).append(Operator.getOperator(operator)).append(value).append("+");
			}
			if(builder.length() > 0)
			{
				builder.deleteCharAt(builder.length());
			}
			return builder.toString();
		}
	}
	
	
}
