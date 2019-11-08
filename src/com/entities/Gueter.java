package com.entities;

public class Gueter {
	
	private String type;
	private double quantitaet;
	
	public Gueter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gueter(String type, double quantitaet) {
		super();
		this.type = type;
		this.quantitaet = quantitaet;
	}

	@Override
	public String toString() {
		return "Gueter [type=" + type + ", quantitaet=" + quantitaet + "]";
	}
	
	

}
