package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements FightingCapable {

	private int payloadCapacityInTons;
	
	public FighterJet(String model, double speed, int range, long price, int capacity) {
		super(model, speed, range, price);
		this.payloadCapacityInTons = capacity;
	}
	
	public void loadPayload(int percentageToLoad) {
		if (percentageToLoad <= 100) {
			float amountToLoad = ((float)(payloadCapacityInTons * percentageToLoad) / 100);
			System.out.printf("Loading %.1f tons of destruction in the " + getModel() + "\n", amountToLoad);
		}
		else {
			System.out.println("I'm sorry, but you have attempted to exceed the payload capacity limits of this aircraft.");
		}
	}
	
	public void fight() {
		System.out.println("Lookout below!! " + getModel() + " is dropping bombs!");
	}
	
	public String toString () {
		return ("Model: " + getModel() + "\t Speed: " + getSpeed() + " MPH \t Range: " + getRange() + " miles \t Price: $" + getPrice() + "\t Payload: " + payloadCapacityInTons + " tons");
	}
	
	public int getPayloadCapacity() {
		return payloadCapacityInTons;
	}

}
