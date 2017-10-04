package com.expedia.model;

public class FlightSegment {

	private long segmentId;
	private String flightDetails;
	private long creditCardFees;
	
	
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
	
	public long getCreditCardFees() {
		return creditCardFees;
	}
	public void setCreditCardFees(long creditCardFees) {
		this.creditCardFees = creditCardFees;
	}

	
}
