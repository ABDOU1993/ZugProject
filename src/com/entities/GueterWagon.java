package com.entities;

import java.util.ArrayList;
import java.util.Collection;

public class GueterWagon extends Wagon{
	
	private Collection<Gueter> gueters = new ArrayList<Gueter>();


	public GueterWagon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GueterWagon(String typenbezeichnung, String baujahr, String seriennummer) {
		super(typenbezeichnung, baujahr, seriennummer);
		// TODO Auto-generated constructor stub
	}
	
	public double getTotalGueter() {
		return gueters.size();
	}
	
	public void addGueter(String type, double q) {
		gueters.add(new Gueter(type, q));
	}
	

}
