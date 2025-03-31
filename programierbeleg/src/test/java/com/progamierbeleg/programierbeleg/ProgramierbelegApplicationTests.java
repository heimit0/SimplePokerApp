package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.Karten.Karte.Farbe;
import com.progamierbeleg.programierbeleg.Karten.Karte.Wert;
import com.progamierbeleg.programierbeleg.Karten.combinations;

@SpringBootTest
class ProgramierbelegApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void isRoyalFlush() {
		ArrayList<Karte> cards = new ArrayList<>();
		cards.add(new Karte(Farbe.KARO, Wert.ASS));
		cards.add(new Karte(Farbe.KARO, Wert.KOENIG));
		cards.add(new Karte(Farbe.KARO, Wert.DAME));
		cards.add(new Karte(Farbe.KARO, Wert.BUBE));
		cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
		cards.add(new Karte(Farbe.KARO, Wert.ACHT));
		cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
		assertEquals(true, combinations.isRoyalFlush(cards));

		ArrayList<Karte> cards2 = new ArrayList<>();
		cards2.add(new Karte(Farbe.KARO, Wert.ASS));
		cards2.add(new Karte(Farbe.PIK, Wert.KOENIG));
		cards2.add(new Karte(Farbe.KARO, Wert.DAME));
		cards2.add(new Karte(Farbe.KARO, Wert.ZWEI));
		cards2.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
		cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
		cards2.add(new Karte(Farbe.PIK, Wert.ZEHN));
		assertEquals(false, combinations.isRoyalFlush(cards2));
	}

	@Test
	void isFullHouse() {
		ArrayList<Karte> cards2 = new ArrayList<>();
		cards2.add(new Karte(Farbe.KARO, Wert.ZEHN));
		cards2.add(new Karte(Farbe.PIK, Wert.ZEHN));
		cards2.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
		cards2.add(new Karte(Farbe.KARO, Wert.ZWEI));
		cards2.add(new Karte(Farbe.KREUZ, Wert.ACHT));
		cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
		cards2.add(new Karte(Farbe.PIK, Wert.VIER));
		assertEquals(true, combinations.isFullHouse(cards2));

		ArrayList<Karte> cards = new ArrayList<>();
		cards.add(new Karte(Farbe.KARO, Wert.ASS));
		cards.add(new Karte(Farbe.KARO, Wert.KOENIG));
		cards.add(new Karte(Farbe.KARO, Wert.DAME));
		cards.add(new Karte(Farbe.KARO, Wert.BUBE));
		cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
		cards.add(new Karte(Farbe.KARO, Wert.ACHT));
		cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
		assertEquals(false, combinations.isFullHouse(cards));
	}

	
}
