package com.metro.sc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TravelTest {

	@Test
	public void testInSufficientBalance() {
		Station stationA1 = new Station("A1");
		Station stationA2 = new Station("A2");
		Station stationA3 = new Station("A3");
		Station stationA4 = new Station("A4");
		Station stationA5 = new Station("A5");
		Station stationA6 = new Station("A6");
		Station stationA7 = new Station("A7");
		
		List<Station> stationList = new ArrayList<Station>();
		
		stationList.add(stationA7);
		stationList.add(stationA6);
		stationList.add(stationA5);
		stationList.add(stationA4);
		stationList.add(stationA3);
		stationList.add(stationA2);
		stationList.add(stationA1);
		
		Eitenary eitenary = new Eitenary(stationList);
		
		Card card = new Card((float)6.0, 12324);
		Travel travel = new Travel(eitenary, card);
		
		Date dateOfTravel = new Date(System.currentTimeMillis());
		try {
			travel.performTravel(dateOfTravel);
		} catch (InsufficientBalanceException e) {
			assertNotNull(e);
		}
		
	}
	
	@Test
	public void testSufficientBalance() {
		Station stationA1 = new Station("A1");
		Station stationA2 = new Station("A2");
		List<Station> stationList = new ArrayList<Station>();
		stationList.add(stationA2);
		stationList.add(stationA1);
		
		Eitenary eitenary = new Eitenary(stationList);
		
		Card card = new Card((float)15.0, 12324);
		Travel travel = new Travel(eitenary, card);
		
		Date dateOfTravel = new Date(System.currentTimeMillis());
		
		try {
			travel.performTravel(dateOfTravel);
		} catch (InsufficientBalanceException e) {
		}
		
		assertEquals((float)1.0, card.getBalance(), 0);
	}

	@Test
	public void testFootFall() {
		Station stationA1 = new Station("A1");
		Station stationA2 = new Station("A2");
		List<Station> stationList = new ArrayList<Station>();
		stationList.add(stationA1);
		stationList.add(stationA2);
		
		Eitenary eitenary = new Eitenary(stationList);
		
		Card card = new Card((float)40.0, 12324);
		Travel travel = new Travel(eitenary, card);
		
		Date dateOfTravel = new Date(System.currentTimeMillis());
		
		try {
			travel.performTravel(dateOfTravel);
		} catch (InsufficientBalanceException e) {
		}
		
		Station stationA3 = new Station("A3");
		stationList.add(stationA3);
		
		try {
			travel.performTravel(dateOfTravel);
		} catch (InsufficientBalanceException e) {
		}
		
		assertEquals(2, stationA1.getFootFalls());
		
	}
	
	@Test
	public void testCardReport() {
		Station stationA1 = new Station("A1");
		Station stationA2 = new Station("A2");
		Station stationA3 = new Station("A3");
		List<Station> stationList = new ArrayList<Station>();
		stationList.add(stationA1);
		stationList.add(stationA2);
		stationList.add(stationA3);
		Eitenary eitenary = new Eitenary(stationList);
		
		Card card = new Card((float)22.0, 12324);
		Travel travel = new Travel(eitenary, card);
		
		Date dateOfTravel = new Date(System.currentTimeMillis());
		
		try {
			travel.performTravel(dateOfTravel);
		} catch (InsufficientBalanceException e) {
		}
		
		//from station
		assertEquals("A1", card.getFromStation().getStationId());
		//tostation
		assertEquals("A3", card.getToStation().getStationId());
		//fare
		assertEquals((float)21, card.getLastTripFare(), 0);
		//balance
		assertEquals((float)1.0, card.getBalance(), 0);
	}
}
