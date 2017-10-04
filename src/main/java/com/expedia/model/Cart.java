package com.expedia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sridhar Panatula
 * @Date   10/2/2017
 *
 */
public class Cart {

	private long Id;
	private long Success_ID;
	private List<FlightSegment> segments = new ArrayList<FlightSegment>();
	private long cardUsed;
	private String cardType;
	Date timeOfPurchase;
	
	public long getSuccess_ID() {
		return Success_ID;
	}

	public void setSuccess_ID(long success_ID) {
		Success_ID = success_ID;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public List<FlightSegment> getSegments() {
		return segments;
	}

	public void setSegments(List<FlightSegment> segments) {
		this.segments = segments;
	}

	public long getCardUsed() {
		return cardUsed;
	}

	public void setCardUsed(long cardUsed) {
		this.cardUsed = cardUsed;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getTimeOfPurchase() {
		return timeOfPurchase;
	}

	public void setTimeOfPurchase(Date timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}	
	
    public float getTotalCCFees(){
    	
    	float sumOfCCFees =0;
    	
    	for(FlightSegment flight:segments){
    		if(flight == null){
    			break;
    		}
    		sumOfCCFees+= flight.getCreditCardFees();
    	}
    	
    	return sumOfCCFees;
    	
    }
	
    
    public FeeRangeWithCardType getFeeRangeAndCardType(){
    	long minimumCCFees = -1;
    	long maximumCCFees = -1;
    	
    	long currentFees;
    	for(FlightSegment flight:segments){
    		if(flight == null){
    			break;
    		}
    		currentFees = flight.getCreditCardFees();
    		
    		if( currentFees < minimumCCFees  || minimumCCFees == -1 ){
    			minimumCCFees = flight.getCreditCardFees();
    		}
    		if (currentFees > maximumCCFees || maximumCCFees == -1){
    			maximumCCFees = flight.getCreditCardFees();
    		}
    	}
    	
    	FeeRangeWithCardType feeRange = new FeeRangeWithCardType();
    	if( minimumCCFees == -1){
    		return null;
    	}else{
    		feeRange.setMaxFees(maximumCCFees);
    		feeRange.setMinFees(minimumCCFees);
    		feeRange.setCardType(getCardType());
    	}
    
    	return feeRange;
    }
}

