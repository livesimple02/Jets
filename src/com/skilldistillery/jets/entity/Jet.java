package com.skilldistillery.jets.entity;

public abstract class Jet {


	private String model;
	private double speed;
	private int range;
	private long price;
	private int flyTimeHours;
	private int flyTimeMinutes;
	
	
	
	public Jet (String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		flyTimeHours = (int)(((double)range / speed));
		flyTimeMinutes = (int)((((double)range / speed) * 60)-(flyTimeHours * 60));
	}

	
	public void fly() {
		System.out.println("The " + model + " is taking off. This jet can fly at a speed of " + speed + " MPH for " + flyTimeHours + " hours and " + flyTimeMinutes + " minutes. The total range is " + range + " miles.");
	}

	
	public double getSpeedInMach(double speed) {
		double result = speed * 0.001303;
		return result;
	}
	
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}
	
	public int getFlyTimeMinutes() {
		return flyTimeMinutes;
	}
	
	
}
