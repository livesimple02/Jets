package com.skilldistillery.jets.entity;

public class CustomJet extends Jet {

	public CustomJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice());
	}

}
