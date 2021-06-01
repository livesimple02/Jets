package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements FightingCapable {

	private int payloadCapacityInTons;
	private float payloadOnBoard = 0;
	
	public FighterJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.payloadCapacityInTons = capacity;
	}
	
	
	
	public void loadPayload(int percentageOfCapacity) {
		System.out.println();
		float amountToLoad = ((float)(payloadCapacityInTons * percentageOfCapacity) / 100);
		if (percentageOfCapacity <= 100 && (amountToLoad + payloadOnBoard) <= payloadCapacityInTons) {
			System.out.printf("Loading %.1f tons of destruction in the " + getModel() + "\n", amountToLoad);
			this.payloadOnBoard += amountToLoad;
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the payload capacity limits of this aircraft.");
		}
	}
	
	
	
	public void fight() {
		System.out.println();
		System.out.println("10-4 ... " + getModel() + " en route to drop some gifts!");
		System.out.println("Flying...");
		System.out.printf("Lookout below!! " + getModel() + " is dropping %.1f tons worth of presents on the enemy! \n", payloadOnBoard);
		System.out.println();
		this.payloadOnBoard = 0;
	}
	
	
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Payload: " + payloadCapacityInTons + " tons");
	}
	
	
	
	public int getPayloadCapacityInTons() {
		return payloadCapacityInTons;
	}
	
	
	public void setPayloadCapacityInTons(int capacity) {
		this.payloadCapacityInTons = capacity;
	}



	public float getPayloadOnboard() {
		return payloadOnBoard;
	}



	public void setPayloadOnboard(float payloadOnboard) {
		this.payloadOnBoard = payloadOnboard;
	}


	
	
}
