package com.metro.sc.price;

public class GetWeekDayPrices implements GetPrices{

	@Override
	public float getPerStationPrice() {
		return 7;
	}

	@Override
	public float getMinimumBalance() {
		return (float)5.5;
	}

}
