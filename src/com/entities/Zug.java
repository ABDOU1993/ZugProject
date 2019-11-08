package com.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class Zug {

	private String id;
	private int maxBenoetigterSchaffner = 0;
	private Deque<Wagon> wagons = new LinkedList<Wagon>();
	private Deque<Lokomotive> lokomotives = new LinkedList<Lokomotive>();

	public Zug(String id) {
		this.id = id;
	}

	public double getLeergewicht() {
		double leerGewicht = 0;
		for (Wagon wagon : wagons) {
			leerGewicht += wagon.getLeergewicht();
		}
		return leerGewicht;
	}

	public int getMaxPassagiere() {
		int maxPassagiere = 0;
		for (Wagon wagon : wagons) {
			maxPassagiere += wagon.getMaxPassagiere();
		}
		return maxPassagiere;
	}

	public double getMaxZuladungsgewicht() {
		double maxZuladungsGewicht = 0;
		for (Wagon wagon : wagons) {
			maxZuladungsGewicht += wagon.getZuladungsgewicht();
		}
		return maxZuladungsGewicht;
	}

	public double getMaxZuladung() {
		return getMaxPassagiere() * 75 + getMaxZuladungsgewicht();
	}

	public double getMaxGesamtgewicht() {
		double maxGesamtGewicht = 0;
		for (Lokomotive l : lokomotives) {
			maxGesamtGewicht += l.getZugkraft();
		}
		return maxGesamtGewicht + this.getLeergewicht() + this.getMaxZuladung();
	}

	// Hier ist eine Methode, die die Laenge des Zuges rechnet
	public int getLaenge() {
		int laenge = 0;
		for (Wagon wagon : wagons) {
			laenge += wagon.getLaenge();
		}
		return laenge;
	}
	
	// Test, ob der Zug fahrfähig ist ...

	public boolean fahrfaehig() {

		int totalPassagiere = this.getTotatlPassagiere();
		double totalGueter = this.getTotatlGueter();

		if (totalPassagiere + totalGueter < this.getMaxPassagiere() + this.getMaxZuladungsgewicht()) {
			return true;
		}
		return false;
	}

	public int getTotatlPassagiere() {
		int sum = 0;
		for (Wagon wagon : wagons) {
			sum += wagon.getTotalPassagiere();
		}
		return sum;
	}

	public int getTotatlGueter() {
		int sum = 0;
		for (Wagon wagon : wagons) {
			sum += wagon.getTotalGueter();
		}
		return sum;
	}

	// hier ist eine Methode zum Test, ob ein Schaffner benoetigt ist
	public int getMaxBenoetigterSchaffner() {

		if (this.getTotatlPassagiere() > this.getMaxPassagiere()) {
			maxBenoetigterSchaffner++;
		}

		for (int i = 0; i < this.getTotatlPassagiere(); i++) {
			if (i > 0 && i % 50 == 0) {
				// System.out.println(i);
				maxBenoetigterSchaffner++;
			}
		}

		return maxBenoetigterSchaffner;
	}

	// Here we add Lokomotives from left (Lokomotives come first then Wagon ...)
	public void attachLeft(Lokomotive l) {
		wagons.addFirst(l);
	}

	// Here we add Wagons from right
	public void attachRight(Wagon wagon) {
		wagons.addLast(wagon);
	}

	@Override
	public String toString() {
		return "Zug [id=" + id + ", maxBenoetigterSchaffner=" + maxBenoetigterSchaffner + ", lokomotives=" + lokomotives
				+ " + , wagons=" + wagons + "]";
	}

	public String print() {	
		String s = "";
		for (Wagon wagon : wagons) {
			if(!wagon.equals(wagons.getLast())) {
				s+=wagon.getSeriennummer()+" <-- ";
			}else {
				s+=wagon.getSeriennummer();
			}
		}
		 return s;
	}

}
