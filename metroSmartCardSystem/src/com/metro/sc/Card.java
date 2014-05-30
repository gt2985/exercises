package com.metro.sc;
/**
 * The card class. Havent used any precision for balance as nothing was specified.
 * 
 * @author GA004TH
 *
 */
public class Card {
	
	private float balance;
	
	private int number;
	
	private Station fromStation;
	
	private Station toStation;
	
	private float lastTripFare;
	
	
	public Card(float balance, int number) {
		this.balance = balance;
		this.number = number;
	}
	
	public float getLastTripFare() {
		return lastTripFare;
	}

	public void setLastTripFare(float lastTripFare) {
		this.lastTripFare = lastTripFare;
	}

	
	public float getBalance() {
		return this.balance;
	}
	
	public void debitBalance(float amount) {
		balance = balance - amount;
	}
	
	public void creditBalance(float amount) {
		balance =  this.balance + amount;
	}

	public int getCardNumber() {
		return number;
	}

	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}
	
}
