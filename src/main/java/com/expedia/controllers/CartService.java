package com.expedia.controllers;

import java.util.List;

import com.expedia.model.Cart;
import com.expedia.model.FeeRangeWithCardType;
import com.expedia.model.FlightSegment;
import com.expedia.model.Response;
import com.expedia.repository.CartRepository;
import com.expedia.utils.Logger;

/*
 *  This is the entry point for our problem exposing all the behavior we need.
 */
public class CartService {

	//possible candidates for Injection
	Logger _logger = new Logger();
	CartRepository cartRepo = new CartRepository();
	
	
	/**  USE CASE 6
	 * SOLVING The BONUS/UseCase 6 of the problem
	 * 
	 * This method will return the estimated cost of using a particular card type
	 * 
	 * I like this method in the cartservice as the payment is out of behavior  of Cart but its manager has to deal with the cost and notifying I did add
	 * a log to notify our analyst of the usage of the cardtype etc., the log  could itself be written into an store(inMemory or DB) for better analysis
	 * Due to the time constraints I am using this simple logger. TODO : need to store the count by userID to improve it for real time analysis
	 * 
	 * 
	 * @param cart
	 *            : the Cart for which user is trying to use this CreditCard for
	 * @return : total expected fees, for all the segments of the cart
	 */
	public double getExpectedTotalFees(Cart cart) {

		String cardType = cart.getCardType();
		PaymentController paymentController = new PaymentController();
		double totalExpectedFee = 0;

		List<FlightSegment> segments = cart.getSegments();
		for (FlightSegment segment : segments) {
			totalExpectedFee += paymentController.getCardFees(segment.getFlightDetails(), cardType);
		}
		_logger.info(" Attempted to use cardType " + cardType + " for the CartId: " + cart.getId() + " Total expected charge is " + totalExpectedFee);
		return totalExpectedFee;
	}
	
	/*
	 * This method exposes the bevior asked in the first sentence of the question to store all the data we need associated with a booking
	 * It has multple flight segments and payment details, possibly some other customer details as we evolve
	 * 
	 * @param newCart  takes the shopping cart and stores using its repository
	 * 
	 * Question: Why reponse object. It is only to show one more of error handling in this short time work, but we can also return null or throw exception based on the layer or the user we expect
	 * Hopefully not an exception but more likely returning null is a valid approach or an Id of successful creation if it was generated in the backend
	 */
	public Response storeBookedTrip(Cart newCart){
		
		Response response = new Response();
		try{
			cartRepo.saveBookedCart(newCart);
		}catch(Exception e){
			response.setSuccess(false);
			response.setErrorCode(40000);
			_logger.log("Unexpected exception, "+ e.getMessage() );
			_logger.log("Unexpected exception, details here: "+ e.getStackTrace().toString());
		}
		return response;		
	}
	
	/*  USE Case 1
	 * This method will return the fees paid by the User for this booking
	 * Returns -1 if it can't find a Cart with the given successId;
	 * 
	 * Question could why don't I use the response object here. It can also be augmented with a complicated Response object but it is simple enough in this case do this way
	 * 
	 */
	public float getTotalFeesPaid(long successId){
		
		float paidCCFees = -1;
		Cart cart = cartRepo.getBookedCart(successId);
		if (null != cart){
			paidCCFees = cart.getTotalCCFees();
		}
		return paidCCFees;
	}
	/* USE case 2
	 * 
	 * This method will return cardtype used to book the travel for given successId 
	 * Will return null if it can't find a cart with given SuccessID
	 */
	public String getCardTypeUsed(long successId){
		String cardType = null;
		Cart cart = cartRepo.getBookedCart(successId);
		if(null != cart){
			cardType = cart.getCardType();
		}
		
		return cardType;
	}

    /*USE CASE 3 & 4 
     * This method will return the range for min & max fees paid for the legs of the booking being requested
     * Will REturn null if Cart is not found with a given successId or there are no flight segments
     * Will also have the Card type associated with each of the Range values
     * 
     * Question: Why not separate: It is appropriate to combine them as both of them are fetched/found in the same flight segment. and we are doing a POC
     */
	public FeeRangeWithCardType getFeeRange(Long successId){
		FeeRangeWithCardType rangeAndType = null;
		Cart cart = cartRepo.getBookedCart(successId);
		if(null != cart){
			rangeAndType = cart.getFeeRangeAndCardType();
		}
		return rangeAndType;
	}
}
