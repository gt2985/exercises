package com.metro.sc;

import java.util.Date;

import com.metro.sc.price.PriceUtils;

public class Travel {
	
	private Eitenary eitenary;
	
	private Card card;
	
	Travel(Eitenary eitenary, Card card) {
		this.eitenary = eitenary;
		this.card = card;
	}
	
	public void performTravel(Date date) throws InsufficientBalanceException {
		
		float perStationPrice = PriceUtils.getPrice(date).getPerStationPrice();
		float minimumBalance = PriceUtils.getPrice(date).getMinimumBalance();
		int numberOfStations = eitenary.getStations().size();
		
		
		eitenary.getStations().get(0).swipeIn(minimumBalance, card);
		
		eitenary.getStations().get(eitenary.getStations().size() - 1).swipeOut(perStationPrice, numberOfStations, card);
		
		
	}

}
