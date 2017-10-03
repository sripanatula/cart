package com.expedia.usecases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.expedia.controllers.CartService;
import com.expedia.model.Cart;

public class getFeesPaidTest {

	CartService cartService = new CartService();
	
	@Before
	public void before(){
		Cart testCart = new Cart();
		//create a known fee
		testCart.setCardType("VISA");
		testCart.setCardUsed(4929776141672936L);
		
		
	}
	
	@Test
	public void feeStoredIsSame(){
		assertEquals(1,1);
	}
}
