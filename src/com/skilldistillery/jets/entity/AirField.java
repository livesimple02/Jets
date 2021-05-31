package com.skilldistillery.jets.entity;

import java.util.List;

public class Airfield {

	private List<Jet> jets;
	private String airfieldName;
	
	public Airfield () {
		
	}
	
	public Airfield(String airfieldName) {
		this.airfieldName = airfieldName;
	}

	public Airfield(List<Jet> jets, String airfieldName) {
		this.jets = jets;
		this.airfieldName = airfieldName;
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	
	public String getAirfieldName() {
		return airfieldName;
	}
	
	public void setAirfieldName(String name) {
		this.airfieldName = name;
	}
	
	
	
}
