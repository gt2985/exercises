package com.metro.sc.price;

public class GetWeekendPrices implements GetPrices{

	@Override
	public float getPerStationPrice() {
		return (float)5.5;
	}

	@Override
	public float getMinimumBalance() {
		return (float)5.5;
	}

}
