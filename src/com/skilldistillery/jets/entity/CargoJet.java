package com.skilldistillery.jets.entity;


public class CargoJet extends Jet implements CargoTransporter {
	
	private int cargoCapacityInLbs;

	public CargoJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.cargoCapacityInLbs = capacity;
	}
	
	public int getCargoCapacityInLbs() {
		return cargoCapacityInLbs;
	}

	public void loadCargo(int percentageToLoad) {
		if (percentageToLoad <= 100) {
			System.out.println("Loading " + (cargoCapacityInLbs * percentageToLoad / 100) + " pounds of cargo in the " + getModel());
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the capacity limits of this aircraft.");
		}
	}
	
	public void unloadCargo() {
		System.out.println("Unloading cargo from " + getModel());
	}
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Cargo Capacity: " + cargoCapacityInLbs + " pounds");
	}
	

}
