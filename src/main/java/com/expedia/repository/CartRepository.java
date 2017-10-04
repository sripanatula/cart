package com.expedia.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.expedia.model.Cart;
import com.expedia.utils.Logger;

public class CartRepository {

	Map<Long, Cart> cartStore = new HashMap<Long, Cart>();
	Map<Long, List> creditCardUsedIndex = new HashMap<Long, List>();
	Logger _logger = new Logger();

	/*
	 * This method will add a given cart to the existing Structure
	 * TODO: Here I need to make it scalable by having multiple clustered index and other mechanisms
	 * for now storing ina  quick retrieval way of Hashmap
	 */
	public Cart saveBookedCart(Cart newCart) {

		Cart addedCart;

		if (null == newCart) {
			throw new IllegalArgumentException("Cart Can't be null");
		}
		cartStore.put(newCart.getSuccess_ID(), newCart);

		///TODO for now simply storing into a hashmap 
		// will work on scaling with some inmomory and some in file storage
		addedCart = cartStore.get(newCart.getSuccess_ID());
		
		
		
		// assuming there are no multiple bookings on the same card
		Long creditCard = (Long) newCart.getCardUsed();
		List<Long> existingBookings = creditCardUsedIndex.get(creditCard);
		if(null == existingBookings){
			existingBookings = new ArrayList<Long>();	
		}
		existingBookings.add(newCart.getSuccess_ID());
		creditCardUsedIndex.put(creditCard, existingBookings);
		return addedCart;
	}

	/*
	 * A method to retrieve cart by the ID as shown in the API reference. 
	 *
	 * Except I chose to return the cart as it has more information than flight segments including Credit card and type etc.,
	 * 
	 * @param successId This is the successful BookingId or the critical ID we are using to identify carts
	 */
	public Cart getBookedCart(long successId) {

		Cart fromStorage;
		fromStorage = cartStore.get(successId);

		return fromStorage;
	}

	/*
	 * A method to count the number of Bookings by a certain card type
	 * This needs to change when I improve it with scaling
	 * 
	 * @Param cardType  used to tell which cardtype like VISA, MASTERCARD ETC.,
	 * In the future it needs to be coming from enum or storage
	 */
	public int getTotalBookingCountByCardtype(String cardType) {
		int totalCount = 0;
		for (Cart cart : cartStore.values()) {
			if (cart.getCardType().equals(cardType)) {
				totalCount++;
			}
		}
		return totalCount;
	}
}
