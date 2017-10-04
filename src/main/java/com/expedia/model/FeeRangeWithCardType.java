package com.expedia.model;

/*
 * A class to store the min, max fees in a booking and also the Cardtype and used as a transport object
 */
public class FeeRangeWithCardType {

	private long minFees;
	private long maxFees;
	private String cardType;
	
	public float getMinFees() {
		return minFees;
	}
	public void setMinFees(long minFees) {
		this.minFees = minFees;
	}
	public float getMaxFees() {
		return maxFees;
	}
	public void setMaxFees(long maxFees) {
		this.maxFees = maxFees;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
}
