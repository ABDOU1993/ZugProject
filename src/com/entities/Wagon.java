package com.entities;

public class Wagon {

	private String typenbezeichnung;
	private String baujahr;
	private String seriennummer;

	private final double leergewicht = 10;
	private final int laenge = 5;
	private final int maxPassagiere = 10;
	private final double zuladungsgewicht = 10;

	public Wagon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wagon(String typenbezeichnung, String baujahr, String seriennummer) {
		super();
		this.typenbezeichnung = typenbezeichnung;
		this.baujahr = baujahr;
		this.seriennummer = seriennummer;		
	}

	public int getTotalPassagiere() {
		return 0;
	}
	public double getTotalGueter() {
		return 0;
	}

	public String getTypenbezeichnung() {
		return typenbezeichnung;
	}

	public void setTypenbezeichnung(String typenbezeichnung) {
		this.typenbezeichnung = typenbezeichnung;
	}

	public String getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}

	public String getSeriennummer() {
		return seriennummer;
	}

	public void setSeriennummer(String seriennummer) {
		this.seriennummer = seriennummer;
	}



	public int getMaxPassagiere() {
		return maxPassagiere;
	}


	public double getZuladungsgewicht() {
		return zuladungsgewicht;
	}

	public double getLeergewicht() {
		return leergewicht;
	}

	public double getLaenge() {
		return laenge;
	}

	@Override
	public String toString() {
		return "Wagon [typenbezeichnung=" + typenbezeichnung + ", baujahr=" + baujahr + ", seriennummer=" + seriennummer
				+ ", maxPassagiere=" + maxPassagiere + ", zuladungsgewicht=" + zuladungsgewicht + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	

}
