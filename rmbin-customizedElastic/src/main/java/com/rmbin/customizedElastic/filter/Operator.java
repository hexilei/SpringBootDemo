package com.rmbin.customizedElastic.filter;

public enum Operator {

	AND("+"),
	GT(">"),
	GTE(">="),
	lT("<"),
	LTE("<=");
	
	private String value;
	
	private String getValue()
	{
		return value;
	}
	
	private void setValue(String value)
	{
		this.value = value;
	}
	
	private Operator(String value)
	{
		this.value = value;
	}
	
	public static String getOperator(Operator operator) throws Exception
	{
		for(Operator oper:Operator.values())
		{
			if(oper.name().equals(operator.name()))
			{
				return oper.value;
			}
		}
		throw new Exception("Invalid operator.");
	}
	
	public static boolean validate(Operator operator)
	{
		for(Operator opera:Operator.values())
		{
			if(operator.name() == opera.name() && operator.value == opera.value)
			{
				return true;
			}
		}
		return false;
	}
}
