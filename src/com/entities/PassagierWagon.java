package com.entities;

import java.util.ArrayList;
import java.util.Collection;

public class PassagierWagon extends Wagon {

	private Collection<Passagier> passagiere = new ArrayList<Passagier>();
	
	public PassagierWagon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassagierWagon(String typenbezeichnung, String baujahr, String seriennummer) {
		super(typenbezeichnung, baujahr, seriennummer);
		// TODO Auto-generated constructor stub
	}

	public int getTotalPassagiere() {
		return passagiere.size();
	}
	
	public void addPassagier(String name,int age) {
		passagiere.add(new Passagier(name,age));
	}
}
