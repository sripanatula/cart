package com.expedia.usecases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.expedia.controllers.CartService;
import com.expedia.model.Cart;
import com.expedia.model.FeeRangeWithCardType;
import com.expedia.model.FlightSegment;

public class CartServiceTests {

	CartService cartService = new CartService();
	
	@Before
	public void before(){
		Cart testCart = createCart();
		testCart.setSuccess_ID(10000L);
		testCart.setCardType("VISA");
		cartService.storeBookedTrip(testCart);
		
		Cart testCart2 = createCart();
		testCart2.setSuccess_ID(20000L);
		testCart2.setCardType("MASTER");
		cartService.storeBookedTrip(testCart2);
		
		Cart testCart3 = createCart();
		testCart3.setSuccess_ID(30000L);
		testCart3.setCardType("VISA");
		cartService.storeBookedTrip(testCart3);
	}

	@Test
	//Use case 1 test
	public void getTotalFeesPaidByUserTest(){
		
		double fees = 5L;
		assertEquals(fees, cartService.getTotalFeesPaid(10000L),0.1);	
	}
	//Use case 2 test
	@Test
	public void getCardTypeUsedTest(){
		String cardType = "VISA";
		assertEquals(cardType,cartService.getCardTypeUsed(10000L));
	}
	//use cases 3 & 4
	@Test
	public void getFeeRangeTest(){
		FeeRangeWithCardType expectedRange = new FeeRangeWithCardType();
		expectedRange.setCardType("VISA");
		
		expectedRange.setMaxFees(3);
		expectedRange.setMinFees(2);
		FeeRangeWithCardType existingRangeObject = cartService.getFeeRange(10000L);
		
		assertEquals(expectedRange.getCardType(), cartService.getFeeRange(10000L).getCardType());
		assertEquals(expectedRange.getMaxFees(), cartService.getFeeRange(10000L).getMaxFees(),0.1);
		assertEquals(expectedRange.getMinFees(), cartService.getFeeRange(10000L).getMinFees(),0.1);
		
	}
	
	//use case 5
	@Test
	public void getNumberofBookingsByCardTypeTest(){
		int count = cartService.getCountOfBookingsByCardtype("VISA");
		assertEquals(count, 2);
	}
	
	private Cart createCart() {
		Cart testCart = new Cart();
		//create a known fee
		testCart.setCardType("VISA");
		testCart.setCardUsed(4929776141672936L);
		List<FlightSegment> segments = new ArrayList<FlightSegment>();
		// Add first segment
		FlightSegment segment1 = new FlightSegment();
		segment1.setCreditCardFees(3);
		segment1.setFlightDetails("JetBlue from Boston to Seattle");
	
		segments.add(segment1);
		// Add Second segment
		FlightSegment segment2 = new FlightSegment();
		segment2.setCreditCardFees(2);
		segment2.setFlightDetails("Allaska Air from Seattle to Boston");
			
		segments.add(segment2);
		testCart.setSegments(segments);
		testCart.setId(1000);
		testCart.setSuccess_ID(10000);
		return testCart;
	}
	
}
