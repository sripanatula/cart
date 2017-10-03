package com.expedia.model;

public class FeeRangeWithCardType {

	private float minFees;
	private String minFeeCardType;
	private float maxFees;
	private String maxFeeCardType;
	
	public float getMinFees() {
		return minFees;
	}
	public void setMinFees(float minFees) {
		this.minFees = minFees;
	}
	public float getMaxFees() {
		return maxFees;
	}
	public void setMaxFees(float maxFees) {
		this.maxFees = maxFees;
	}
	public String getMinFeeCardType() {
		return minFeeCardType;
	}
	public void setMinFeeCardType(String minFeeCardType) {
		this.minFeeCardType = minFeeCardType;
	}
	public String getMaxFeeCardType() {
		return maxFeeCardType;
	}
	public void setMaxFeeCardType(String maxFeeCardType) {
		this.maxFeeCardType = maxFeeCardType;
	}
	
	
	
}
