package com.expedia.model;

import java.util.Date;

public class FlightSegment {

	private long segmentId;
	private String flightDetails;
	private String creditCardType;
	private float creditCardFees;
	
	
	public long getFlightId() {
		return segmentId;
	}
	public void setFlightId(long flightId) {
		this.segmentId = flightId;
	}
	public String getFlightDetails() {
		return flightDetails;
	}
	public void setFlightDetails(String flightDetails) {
		this.flightDetails = flightDetails;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	public float getCreditCardFees() {
		return creditCardFees;
	}
	public void setCreditCardFees(float creditCardFees) {
		this.creditCardFees = creditCardFees;
	}

	
}
