package com.J.common;

import org.apache.hadoop.io.Text;

public class AirlinePerformanceParser {
	private int year;
	private int month;
	private int day;
	
	private int arriveDelayTime = 0;
	private int departureDelayTime = 0;
	private int distance = 0;
	
	private boolean arriveDelayAvailable = true;
	private boolean departureDelayAvailable = true;
	private boolean distanceAvailable = true;
	
	private String uniqueCarrier;
	
	public AirlinePerformanceParser(Text text) {
		try {
			String[] columns = text.toString().split(",");
			
			year = Integer.parseInt(columns[0]);
			month = Integer.parseInt(columns[1]);
			day = Integer.parseInt(columns[2]);
			uniqueCarrier = columns[5];
			
			if(!columns[16].equals("")) {
				departureDelayTime = (int)Float.parseFloat(columns[16]);
			} else {
				departureDelayAvailable = false;
			}
			if(!columns[26].equals("")) {
				arriveDelayTime = (int)Float.parseFloat(columns[26]);
			} else {
				arriveDelayAvailable = false;
			}
			if(!columns[37].equals("")) {
				distance = (int)Float.parseFloat(columns[37]);
			} else {
				distanceAvailable = false;
			}
			
		} catch (Exception e) {
			
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getArriveDelayTime() {
		return arriveDelayTime;
	}

	public void setArriveDelayTime(int arriveDelayTime) {
		this.arriveDelayTime = arriveDelayTime;
	}

	public int getDepartureDelayTime() {
		return departureDelayTime;
	}

	public void setDepartureDelayTime(int departureDelayTime) {
		this.departureDelayTime = departureDelayTime;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isArriveDelayAvailable() {
		return arriveDelayAvailable;
	}

	public void setArriveDelayAvailable(boolean arriveDelayAvailable) {
		this.arriveDelayAvailable = arriveDelayAvailable;
	}

	public boolean isDepartureDelayAvailable() {
		return departureDelayAvailable;
	}

	public void setDepartureDelayAvailable(boolean departureDelayAvailable) {
		this.departureDelayAvailable = departureDelayAvailable;
	}

	public boolean isDistanceAvailable() {
		return distanceAvailable;
	}

	public void setDistanceAvailable(boolean distanceAvailable) {
		this.distanceAvailable = distanceAvailable;
	}

	public String getUniqueCarrier() {
		return uniqueCarrier;
	}

	public void setUniqueCarrier(String uniqueCarrier) {
		this.uniqueCarrier = uniqueCarrier;
	}
	
	
	
}
