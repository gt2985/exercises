package com.metro.sc.price;

import java.util.Calendar;
import java.util.Date;

public class PriceUtils {
	
	public static GetPrices getPrice(Date date) {
		
		GetPrices getPrices = null;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
			getPrices = new GetWeekendPrices();
		} else{
			getPrices = new GetWeekDayPrices();
		}
		
		return getPrices;
	}

}
