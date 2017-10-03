package com.expedia.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.expedia.model.Cart;
import com.expedia.repository.CartRepository;

public class CartRepositoryAddTest {

	private CartRepository cartRepository;
	
	@Before
	public void before(){
		cartRepository = new CartRepository();
	}
	
	@Test
	public void hasCartBeenAddedToRepository(){
		
		Cart newCart= new Cart();
		newCart.setId(1L);
		newCart.setSuccess_ID((long) Math.random() * 10);
		
		Cart addedCart = cartRepository.saveBookedCart(newCart);
		assertEquals(addedCart.getSuccess_ID(), newCart.getSuccess_ID());
	}
	

}
