package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.Airfield;
import com.skilldistillery.jets.entity.CargoJet;
import com.skilldistillery.jets.entity.CustomJet;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.Jet;
import com.skilldistillery.jets.entity.PassengerJet;

public class JetsApplication {

	private Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {


		JetsApplication app = new JetsApplication();
		app.runJetsApp();

		
	}
	
	public void runJetsApp() {
		
		boolean keepRunning = true;
		
		Airfield airfield = initializeAirfield("jets.csv");
		
		while (keepRunning) {
			keepRunning = displayUserMenu(airfield);
		}
		
	}
	
	public boolean displayUserMenu(Airfield airfield) {
		
		System.out.println();
		System.out.println("Enter the number of the option you would like to perform.");
		System.out.println();
		System.out.println("1. List Fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load Cargo Jets");
		System.out.println("6. Activate fighter jets");
		System.out.println("7. Charter a passenger flight");
		System.out.println("8. Add a jet to the fleet");
		System.out.println("9. Remove a jet from the fleet");
		System.out.println("10. Quit");
		
		String userResponse = input.nextLine();
		
		switch (userResponse) {
		case "1":
			displayAllJets(airfield);
			break;
		case "2":
			flyAllJets(airfield);
			break;
		case "3":
			displayFastestJet(airfield);
			break;
		case "4":
			displayLongestRangeJet(airfield);
			break;
		case "5":
			loadCargoJets(airfield);
			break;
		case "6":
			activateFighterJets(airfield);
			break;
		case "7":
			transportPassengers(airfield);
			break;
		case "8":
			addJetToFleet(airfield);
			break;
		case "9":
			removeJetFromFleet(airfield);
			break;
		case "10":
			System.out.println("Goodbye!");
			return false;
		default:
			System.out.println("Invalid Entry. Please try again.");
		}
		
		return true;
		
	} // End of displayMenu method;
	
	
	public void displayAllJets(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		
		System.out.println();
		System.out.println(airfield.getAirfieldName() + " contains the following jets:");
		for (Jet jet : allJets) {
			System.out.println(jet.toString());
		}
			
	} // End of displayAllJets method
	
	public void flyAllJets(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		for (Jet jet : allJets) {
			jet.fly();
		}
	} // End of flyAllJets method
	
	public void displayFastestJet(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		Jet fastestJet = null;
		for (Jet jet : allJets) {
			if (fastestJet == null) {
				fastestJet = jet;
			}
			else if (fastestJet.getSpeed() > jet.getSpeed()) {
				
			}
			else {
				fastestJet = jet;
			}
		}
		System.out.println("The fastest jet in your fleet is the: ");
		System.out.println(fastestJet.toString());
		
	} // End of displayFastestJet method
	
	public void displayLongestRangeJet(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		Jet longestRangeJet = null;
		for (Jet jet : allJets) {
			if (longestRangeJet == null) {
				longestRangeJet = jet;
			}
			else if (longestRangeJet.getRange() > jet.getRange()) {
				
			}
			else {
				longestRangeJet = jet;
			}
		}
		System.out.println("The jet with the longest range in your fleet is the: ");
		System.out.println(longestRangeJet.toString());
		
	} // End of displayLongestRangeJet
	
	
	public void loadCargoJets(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		List<CargoJet> allCargoJets = new ArrayList<>();
		for (Jet jet : allJets) {
	
			if (jet instanceof CargoJet) {
				allCargoJets.add((CargoJet)jet);
				
			}
		}
		
		System.out.println("Please select the Cargo Jet you would like to load: ");
		int jetNumber = 1;
		for (int i = 0; i < allCargoJets.size(); i++) {
			System.out.println(jetNumber + ": " + allCargoJets.get(i).getModel() + "\t Cargo Capacity: " + allCargoJets.get(i).getCargoCapacityInLbs() + " pounds.");
			jetNumber ++;
		}
		System.out.println(jetNumber + ": Load All Cargo Jets");
		
		boolean validEntry = false;
		while (validEntry == false) {
			try {
				int userResponseJetToLoad = Integer.valueOf(input.nextLine())-1;
				System.out.print("What percentage of cargo capcity would you like to load?: ");
				int userResponsePercentageToLoad = input.nextInt();
				input.nextLine();
				if (userResponseJetToLoad == allCargoJets.size()) {
					for (CargoJet cargoJet : allCargoJets) {
						cargoJet.loadCargo(userResponsePercentageToLoad);
					}
					validEntry = true;
				}
				else {
					allCargoJets.get(userResponseJetToLoad).loadCargo(userResponsePercentageToLoad);
					validEntry = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Jet Selection. Please try again");
			}
		}
	}
	
	
	public void activateFighterJets(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		List<FighterJet> allFighterJets = new ArrayList<>();
		for (Jet jet : allJets) {
	
			if (jet instanceof FighterJet) {
				allFighterJets.add((FighterJet)jet);
				
			}
		}
		
		System.out.println("Please select the Fighter Jet you would like to activate: ");
		int jetNumber = 1;
		for (int i = 0; i < allFighterJets.size(); i++) {
			System.out.println(jetNumber + ": " + allFighterJets.get(i).getModel() + "\t Payload Capacity: " + allFighterJets.get(i).getPayloadCapacity() + " tons.");
			jetNumber ++;
		}
		System.out.println(jetNumber + ": Activate all Fighter Jets");
		
		boolean validEntry = false;
		while (validEntry == false) {
			try {
				int userResponseJetToLoad = Integer.valueOf(input.nextLine())-1;
				System.out.print("What percentage of payload capcity would you like to load?: ");
				int userResponsePercentageToLoad = input.nextInt();
				input.nextLine();
				if (userResponseJetToLoad == allFighterJets.size()) {
					for (FighterJet fighterJet : allFighterJets) {
						fighterJet.loadPayload(userResponsePercentageToLoad);
					}
					validEntry = true;
				}
				else {
					allFighterJets.get(userResponseJetToLoad).loadPayload(userResponsePercentageToLoad);
					validEntry = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Jet Selection. Please try again");
			}
		}
	}
	
	
	public void transportPassengers(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		List<PassengerJet> allPassengerJets = new ArrayList<>();
		for (Jet jet : allJets) {
	
			if (jet instanceof PassengerJet) {
				allPassengerJets.add((PassengerJet)jet);
				
			}
		}
		
		System.out.println("Please select the Passenger Jet you would like to load: ");
		int jetNumber = 1;
		for (int i = 0; i < allPassengerJets.size(); i++) {
			System.out.println(jetNumber + ": " + allPassengerJets.get(i).getModel() + "\t Capacity: " + allPassengerJets.get(i).getPassengerCapacity() + " persons.");
			jetNumber ++;
		}
		System.out.println(jetNumber + ": Load All Passenger Jets");
		
		boolean validEntry = false;
		while (validEntry == false) {
			try {
				int userResponseJetToLoad = Integer.valueOf(input.nextLine())-1;
				System.out.print("What percentage of passenger capcity would you like to board?: ");
				int userResponsePercentageToLoad = input.nextInt();
				input.nextLine();
				if (userResponseJetToLoad == allPassengerJets.size()) {
					for (PassengerJet passengerJet : allPassengerJets) {
						passengerJet.boardPassengers(userResponsePercentageToLoad);
					}
					validEntry = true;
				}
				else {
					allPassengerJets.get(userResponseJetToLoad).boardPassengers(userResponsePercentageToLoad);
					validEntry = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Jet Selection. Please try again");
			}
		}
	}
	
	public void addJetToFleet(Airfield airfield) {
		boolean validResponse = false;
		
		System.out.println("Please select the type of aircraft you would like to add: ");
		System.out.println("1. Cargo Jet");
		System.out.println("2. Fighter Jet");
		System.out.println("3. Passenger Jet");
		System.out.println("4. Custom Jet");
		
		while (validResponse == false) {
			String userResponse = input.nextLine();
			
			switch (userResponse) {
			case "1":
			case "2":				
			case "3":		
			case "4":
				Jet jetToAdd = buildNewJet(userResponse);
				airfield.getJets().add(jetToAdd);
				validResponse = true;
				System.out.println("Jet successfully added!");
				break;
				
			default:
				System.out.println("Invalid Entry. Please try again");
			}
			
		}
		

		
	}
	
	public Jet buildNewJet(String selection) {
		System.out.print("Enter the model: ");
		String model = input.nextLine();
		System.out.print("Enter the speed in MPH: ");
		double speed = input.nextDouble();
		System.out.println("Enter the range in miles: ");
		int range = input.nextInt();
		System.out.println("Enter the price in dollars: ");
		long price = input.nextLong();
		int capacity = 0;
		Jet newJet;
		
		switch (selection) {
		case "1":
			System.out.println("Enter the cargo capacity in pounds: ");
			capacity = input.nextInt();
			newJet = new CargoJet(model, speed, range, price, capacity);
			break;
		case "2":
			System.out.println("Enter the payload capacity in tons: ");
			capacity = input.nextInt();
			newJet = new FighterJet(model, speed, range, price, capacity);
			break;
		case "3":
			System.out.println("Enter the passenger capacity: ");
			capacity = input.nextInt();
			newJet = new PassengerJet(model, speed, range, price, capacity);
			break;
		default:
			newJet = new CustomJet(model, speed, range, price);
		}
		input.nextLine();
		return newJet;
	}
	
	
	public void removeJetFromFleet(Airfield airfield) {
		List<Jet> allJets = airfield.getJets();
		boolean validResponse = false;
		int jetNumber = 1;
		
		System.out.println("Select the number of the jet you would like to remove or '0' to return to main menu: ");
		for (int i = 0; i < allJets.size(); i++) {
			System.out.println(jetNumber + ": " + allJets.get(i).toString());
			jetNumber++ ;
		}
		while (validResponse == false) {
			String userResponse = input.nextLine();
			int userReponseInteger = Integer.valueOf(userResponse);
			if (userReponseInteger == 0) {
				validResponse = true;
			}
			else if (userReponseInteger < jetNumber) {
				Jet jetToRemove = allJets.get(userReponseInteger - 1);
				airfield.getJets().remove(jetToRemove);
				validResponse = true;
				System.out.println("Jet succesfully removed.");
			}
			else {
				System.out.println("Invalid entry, please make another selection");
			}
		
			
		}
	}
	
	
	
	public Airfield initializeAirfield(String filename) {
		System.out.println("Welcome to your fleet of Jets!");
		System.out.print("Please name your airfield: ");
		String airfieldName = input.nextLine();
		List<Jet> jetsInFile = readJetsFromFile(filename);
		Airfield airfield = new Airfield(jetsInFile, airfieldName);
		return airfield;

	} // End of initializeAirfield method
	
	public List<Jet> readJetsFromFile(String filename) {
		
		List<Jet> jetsList = new ArrayList<>();
		
		try ( BufferedReader bufIn = new BufferedReader(new FileReader(filename)) ) {
			  String line;
			  while ((line = bufIn.readLine()) != null) {
			    if (!line.startsWith("Category")) {
			    	String[] arrOfStrings = line.split(", ");
			    	Jet currentJet = buildJet(arrOfStrings);
			    	jetsList.add(currentJet);			    	
			    }
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}

		return jetsList;
		
	} // End of readJetsFromFile method
	
	public Jet buildJet(String[] arrOfStrings) {
		String category = "";
		String model = "";
		Double speed = 0.0;
		Integer range = 0;
		Long price = 0L;	
		Integer capacity = 0;
		Jet currentJet;
		
		try {
			category = arrOfStrings[0];
			model = arrOfStrings[1];
			speed = Double.valueOf(arrOfStrings[2]);
			range = Integer.valueOf(arrOfStrings[3]);
			price = Long.valueOf(arrOfStrings[4]);
			capacity = Integer.valueOf(arrOfStrings[5]);
		}
		catch(Exception e) {
			
		}
		
		
		switch (category.toLowerCase()) {
		case ("cargo"):
			currentJet = new CargoJet(model, speed, range, price, capacity);
			break;
		case ("passenger"):
			currentJet = new PassengerJet(model, speed, range, price, capacity);
			break;
		case ("fighter"):
			currentJet = new FighterJet(model, speed, range, price, capacity);
			break;
		default:
			currentJet = new CustomJet(model, speed, range, price);
		}
		
		return currentJet;

	} // End of buildJet method
	

}
