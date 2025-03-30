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
		assertEquals(true, combinations.isRoyalFlush(cards));
	}

}
