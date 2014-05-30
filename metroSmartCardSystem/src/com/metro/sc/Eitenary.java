package com.metro.sc;

import java.util.ArrayList;
import java.util.List;

public class Eitenary {
	
	private List<Station> stationList = new ArrayList<Station>();
	
	public Eitenary() {
	}
	
	public Eitenary(List<Station> stationList) {
		this.stationList = stationList;
	}
	
	public void addStation(Station station) {
		if (station != null) {
			stationList.add(station);
		}
	}
	
	public List<Station> getStations() {
		return this.stationList;
	}

}
