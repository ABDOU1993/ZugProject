package com.Tests;

import org.junit.Test;

import com.entities.Antriebsarten;
import com.entities.GueterWagon;
import com.entities.Lokomotive;
import com.entities.PassagierWagon;
import com.entities.Wagon;
import com.entities.Zug;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TestJunit {

	Zug z = new Zug("Zug_01");
	List<Wagon> listWagons = new ArrayList<Wagon>();

	// Here we create examples of PassagierWagon
	PassagierWagon pWagon1 = new PassagierWagon("Typ_P", "1990", "pWagon01");
	PassagierWagon pWagon2 = new PassagierWagon("Typ_P", "1970", "pWagon02");

	// Here we create examples of GueterWAgon
	GueterWagon gWagon1 = new GueterWagon("Typ_G", "1800", "gWagon04");
	GueterWagon gWagon2 = new GueterWagon("Typ_G", "1650", "gWagon05");

	// Here we add Lokomotive
	Lokomotive l = new Lokomotive("Typ_L", "2000", "loko01");

	public void init() {
		l.setAntriebsarten(Antriebsarten.Dampf);

		// Here we add Passengers
		for (int i = 0; i < 10; i++) {
			pWagon1.addPassagier("P" + i, 10 + i);
		}
		for (int i = 0; i < 80; i++) {
			pWagon2.addPassagier("P" + i, 25 + i);
		}

		// Here we add Gueter
		for (int i = 0; i < 12; i++) {
			gWagon1.addGueter("G" + i, 10 + i);
		}
		for (int i = 0; i < 5; i++) {
			gWagon2.addGueter("G" + i, 5 + i);
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

		z.attachLeft(l);
		z.attachRight(gWagon1); 
		z.attachRight(pWagon1); 
		z.attachRight(gWagon2); 
		z.attachRight(pWagon2);
	}

	// Test to check the length of the train (Zugslaenge)
	@Test
	public void testZugLaenge() {
		init();
		assertEquals(25, z.getLaenge());
	}

	// Test to check the Max Benoetigter Schaffner
	@Test
	public void testZugsMaxBenoetigterSchaffner() {
		init();
		assertEquals(2, z.getMaxBenoetigterSchaffner());
	}

	// Test, ob der Zug fahrfähig ist ...
	@Test
	public void testObZugFahrfaehig() {
		init();
		assertEquals(false, z.fahrfaehig());
	}
	
	// Testen der Komposition der Zug (keine Zyklus)
	/*
	@Test
	public void testZugKomposition() {
		init();
		assertEquals("loko01 <-- pWagon01 <-- pWagon02 "
				+ "<-- gWagon04 <-- gWagon05", z.print());
	}*/
	
	
	// Testen der Komposition der Zug (keine Zyklus), Test case 2
	@Test
	public void testZugKomposition2() {
		init();
		//System.out.println(z.print());
		assertEquals("loko01 <-- gWagon04 <-- pWagon01 "
				+ "<-- gWagon05 <-- pWagon02", z.print());
	}

}
