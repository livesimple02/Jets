package com.skilldistillery.jets.entity;

public class PassengerJet extends Jet implements PassengerTransporter {

	private int passengerCapacity;
	private int passengersOnBoard = 0;
	
	public PassengerJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.passengerCapacity = capacity;
	}
	
	

	public void boardPassengers(int percentageOfCapacity) {
		System.out.println();
		int passengersToLoad = (passengerCapacity * percentageOfCapacity / 100);
		if (percentageOfCapacity <= 100 && (passengersOnBoard + passengersToLoad) <= passengerCapacity) {
			System.out.println("Boarding " + passengersToLoad + " passengers onto the " + getModel());
			this.passengersOnBoard += (passengerCapacity * percentageOfCapacity / 100);
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the passenger capacity limits of this aircraft.");
		}
		
	}
	
	
	
	public void deboardPassengers() {
		System.out.println();
		System.out.println("We want to thank you for choosing to fly with us today. Sit back and enjoy your flight!");
		System.out.println("Flying...");
		System.out.println("Welcome to your destination! We ask that all " + passengersOnBoard + " passengers exit the plane in an orderly fashion!");
		this.passengersOnBoard = 0;
	}
	
	
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Capacity: " + passengerCapacity + " persons");
	}
	
	
	
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	
	
	
	public void setPassengerCapacity(int capacity) {
		this.passengerCapacity = capacity;
	}



	public int getPassengersOnBoard() {
		return passengersOnBoard;
	}



	public void setPassengersOnBoard(int passengersOnBoard) {
		this.passengersOnBoard = passengersOnBoard;
	}
	
	
	
}
