package com.rmbin.customizedElastic.core;

/**
 * Construct shard data
 * @author louis.he
 *
 */
public class ShardModel {
	
	private int total;
	
	private int sucessNum;
	
	private int skipNum;
	
	private int failNum;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSucessNum() {
		return sucessNum;
	}

	public void setSucessNum(int sucessNum) {
		this.sucessNum = sucessNum;
	}

	public int getSkipNum() {
		return skipNum;
	}

	public void setSkipNum(int skipNum) {
		this.skipNum = skipNum;
	}

	public int getFailNum() {
		return failNum;
	}

	public void setFailNum(int failNum) {
		this.failNum = failNum;
	}

}
