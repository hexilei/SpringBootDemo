package com.rmbin.customizedElastic.core;


public class ResultModel {
	
	private String index;
	
	private String type;
	
	private String id;
	
	private Float score;

	private Object source;
	
	private Object highlight;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public Object getHighlight() {
		return highlight;
	}

	public void setHighlight(Object highlight) {
		this.highlight = highlight;
	}
}
