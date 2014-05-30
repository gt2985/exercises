package com.metro.sc;

public class Station {
	
	private String stationId;
	
	private int swipeInCount;
	
	private int swipeOutCount;
	
	public Station(String stationId) {
		this.stationId = stationId;
	}
	
	/**
	 * Method that lets swipein at a station
	 * @param minimumBalance
	 * @param card
	 * @throws InsufficientBalanceException
	 */
	public void swipeIn(float minimumBalance, Card card) throws InsufficientBalanceException {
		if (card.getBalance() >= minimumBalance) {
			this.swipeInCount = swipeInCount + 1;
			card.setFromStation(this);
		} else {
			throw new InsufficientBalanceException();
		}
	}
	
	/**
	 * Method that lets swipe out at a station
	 * @param perStationPrice
	 * @param numberOfStations
	 * @param card
	 * @throws InsufficientBalanceException
	 */
	public void swipeOut(float perStationPrice, int numberOfStations, Card card) throws InsufficientBalanceException {
		float fare = numberOfStations * perStationPrice;
		if (card.getBalance() >= fare) {
			this.swipeOutCount = swipeOutCount + 1;
			card.debitBalance(fare);
			card.setLastTripFare(fare);
			card.setToStation(this);
		} else {
			throw new InsufficientBalanceException();
		}
		
	}
	
	/**
	 * Method to report total foolfalls on a station.
	 * @return
	 */
	public int getFootFalls() {
		return this.swipeInCount + this.swipeOutCount;
	}
	
	public String getStationId() {
		return stationId;
	}

}
