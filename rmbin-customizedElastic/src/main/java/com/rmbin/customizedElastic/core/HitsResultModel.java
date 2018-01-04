package com.rmbin.customizedElastic.core;

import java.util.List;

public class HitsResultModel {

	private ShardModel shardModel;
	
	private int totalHits;
	
	private float maxScore;
	
	List<ResultModel> hits;

	public ShardModel getShardModel() {
		return shardModel;
	}

	public void setShardModel(ShardModel shardModel) {
		this.shardModel = shardModel;
	}

	public int getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(int totalHits) {
		this.totalHits = totalHits;
	}

	public float getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(float maxScore) {
		this.maxScore = maxScore;
	}

	public List<ResultModel> getHits() {
		return hits;
	}

	public void setHits(List<ResultModel> hits) {
		this.hits = hits;
	}
}
