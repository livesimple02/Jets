package com.skilldistillery.jets.entity;


public class CargoJet extends Jet implements CargoTransporter {
	
	private int cargoCapacityInLbs;
	private int cargoOnBoard = 0;

	public CargoJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.cargoCapacityInLbs = capacity;
	}
	

	
	public void loadCargo(int percentageToLoad) {
		System.out.println();
		int cargoToLoad = (cargoCapacityInLbs * percentageToLoad / 100);
		if (percentageToLoad <= 100 && (cargoToLoad + cargoOnBoard) <= cargoCapacityInLbs) {
			System.out.println("Loading " + cargoToLoad + " pounds of cargo in the " + getModel());
			this.cargoOnBoard += (cargoCapacityInLbs * percentageToLoad / 100);
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the capacity limits of this aircraft.");
		}
	}
	
	
	
	public void unloadCargo() {
		System.out.println();
		System.out.println("Overnight air delivery is our specialty");
		System.out.println("Flying...");
		System.out.println("Christmas has come early... unloading " + cargoOnBoard + " lbs of cargo.");
		this.cargoOnBoard = 0;
	}
	
	
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Cargo Capacity: " + cargoCapacityInLbs + " pounds");
	}
	
	
	
	public int getCargoCapacityInLbs() {
		return cargoCapacityInLbs;
	}
	
	
	public void setCargoCapacityInLbs(int capacity) {
		this.cargoCapacityInLbs = capacity;
	}



	public int getCargoOnBoard() {
		return cargoOnBoard;
	}



	public void setCargoOnBoard(int cargoOnBoard) {
		this.cargoOnBoard = cargoOnBoard;
	}

	
	
}
