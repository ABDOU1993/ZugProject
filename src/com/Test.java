package com;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.entities.Antriebsarten;
import com.entities.GueterWagon;
import com.entities.Lokomotive;
import com.entities.PassagierWagon;
import com.entities.Wagon;
import com.entities.Zug;


public class Test {

	public static void main(String[] args) {
		
		Zug z = new Zug("Zug_01");
		List<Wagon> listWagons = new ArrayList<Wagon>();
		
		// Here we create examples of PassagierWagon
		PassagierWagon pWagon1 = 
				new PassagierWagon("Typ_P", "1990", "pWagon01");
		PassagierWagon pWagon2 = 
				new PassagierWagon("Typ_P", "1970", "pWagon02");		
		
		// Here we create examples of GueterWAgon
		GueterWagon gWagon1 = new GueterWagon("Typ_G", "1800", "gWagon04");
		GueterWagon gWagon2 = new GueterWagon("Typ_G", "1650", "gWagon05");
		
		// Here we add Lokomotive
		Lokomotive l = new Lokomotive("Typ_L","2000", "loko01");
		// Here we set the Antriebsart : Dampf for example
		l.setAntriebsarten(Antriebsarten.Dampf);
		
		// Here we add Passengers
		for(int i=0;i<10;i++) {
			pWagon1.addPassagier("P"+i, 10+i);
		}
		for(int i=0;i<80;i++) {
			pWagon2.addPassagier("P"+i, 25+i);
		}
		
		// Here we add Gueter
		for(int i=0;i<12;i++) {
			gWagon1.addGueter("G"+i, 10+i);
		}
		for(int i=0;i<5;i++) {
			gWagon2.addGueter("G"+i, 5+i);
		}
		
		
		// Here we add some Passengers and Gueters to l (Lokomotive)
		l.addPassagier("X", 50);
		l.addPassagier("Y", 40);
		l.addGueter("F1", 60);
		l.addGueter("F2", 100);
		
		listWagons.add(pWagon1);
		listWagons.add(pWagon2);
		listWagons.add(gWagon1);
		listWagons.add(gWagon2);
		listWagons.add(l);
		
		// Train Composition test case 1
		// here i've attached the locomotive from the left ...
		/*
		z.attachLeft(l);
		for (Wagon wagon : listWagons) {
			
			// here we test if the wagon object is not a typeof locomotive, 
			// (to ensure that no locomotive will be added twice)
			if(!wagon.equals(l)) {
				z.attachRight(wagon);
			}
			
		}*/
		
		// Train Composition test case 2
		z.attachLeft(l);
		z.attachRight(gWagon1); // Seriennummer = gWagon04
		z.attachRight(pWagon1); // Seriennummer = pWagon01
		z.attachRight(gWagon2); // Seriennummer = gWagon05
		z.attachRight(pWagon2); // Seriennummer = pWagon02
		
	
		
		// System.out.println(z.print());
		System.out.println(z.print()+"\n");		
		// Here we call some methods of the Zug.class
		
		System.out.println("Die gesamte Laenge des Zuges : "+z.getLaenge());
		System.out.println("Wie viel Schaffner sind benoetigt :"+z.getMaxBenoetigterSchaffner());
		System.out.println("Der Anzahl der Passagiere "+z.getTotatlPassagiere());
		System.out.println("Der Quantitaet der Gueter "+z.getTotatlGueter());
		System.out.println("Der maximalen Anzahl der Passagiere : "+z.getMaxPassagiere());
		System.out.println("Der maximalen Zuladungsgewicht : "+z.getMaxZuladungsgewicht());
		
		System.out.println("------------------");
		
		System.out.println("ist der Zug fahrfaehig ? "+z.fahrfaehig());
		
		
	}
	
}
