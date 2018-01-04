package com.rmbin.customizedElastic.core;

public class Page {
	
	private int size;
	
	private int total;
	
	public Page(int size)
	{
		this.size = size;
	}
	
	public Page(int size, int total)
	{
		this.size = size;
		this.total  = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
