package com.skilldistillery.jets.entity;

public class PassengerJet extends Jet implements PassengerTransporter {

	private int passengerCapacity;
	
	public PassengerJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.passengerCapacity = capacity;
	}

	public void boardPassengers(int percentageToLoad) {
		if (percentageToLoad <= 100) {
			System.out.println("Boarding " + (passengerCapacity * percentageToLoad / 100) + " passengers onto the " + getModel());
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the passenger capacity limits of this aircraft.");
		}
		
	}
	
	public void deboardPassengers() {
		System.out.println("Passengers are deboarding from " + getModel());
	}
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Capacity: " + passengerCapacity + " persons");
	}
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
}
