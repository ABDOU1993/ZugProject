package com.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Lokomotive extends Wagon {

	private final double zugkraft = 10;
	private Antriebsarten antriebsarten;
	private Collection<Passagier> passagiere = new ArrayList<Passagier>();
	private Collection<Gueter> gueters = new ArrayList<Gueter>();
	
	public Lokomotive() {
		super();
	}

	public Lokomotive(String typenbezeichnung, String baujahr, String seriennummer) {
		super(typenbezeichnung, baujahr, seriennummer);
	}

	public double getZugkraft() {
		return zugkraft;
	}

	public Antriebsarten getAntriebsarten() {
		return antriebsarten;
	}	
	
	public void addPassagier(String name,int age) {
		passagiere.add(new Passagier(name,age));
	}
	
	public void addGueter(String type, double q) {
		gueters.add(new Gueter(type, q));
	}

	public void setAntriebsarten(Antriebsarten antriebsarten) {
		this.antriebsarten = antriebsarten;
	}
	
	

}
