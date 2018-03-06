package com.rmbin.customizedElastic.filter;

public class Parameter {
	
	private String name;
	
	private String value;
	
	private Operator operator;

	public Parameter(String name, String value, Operator operator)
	{
		this.name = name;
		this.value = value;
		this.operator = operator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
