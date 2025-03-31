package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.Karten.Karte.Farbe;
import com.progamierbeleg.programierbeleg.Karten.Karte.Wert;
import com.progamierbeleg.programierbeleg.Karten.combinations;

@SpringBootTest
public class combinationstest {
    
    @Test
    void toInt() {
        Karte k = new Karte(Farbe.HERZ, Wert.ZEHN);
        Karte k2 = new Karte(Farbe.KARO, Wert.ACHT);
        Karte k3 = new Karte(Farbe.KREUZ, Wert.DAME);
        Karte k4 = new Karte(Farbe.KREUZ, Wert.KOENIG);
        Karte k5 = new Karte(Farbe.KREUZ, Wert.ASS);

        assertEquals(10, k.toInt());
        assertEquals(8, k2.toInt());
        assertEquals(12, k3.toInt());
        assertEquals(13, k4.toInt());
        assertEquals(14, k5.toInt());
    }

    @Test
    void sort() {
        ArrayList<Karte> cards2 = new ArrayList<>();
        cards2.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards2.add(new Karte(Farbe.PIK, Wert.BUBE));
        cards2.add(new Karte(Farbe.KREUZ, Wert.DAME));
        cards2.add(new Karte(Farbe.KARO, Wert.NEUN));
        cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards2.add(new Karte(Farbe.KARO, Wert.SIEBEN));
        cards2.add(new Karte(Farbe.KARO, Wert.SECHS));

        ArrayList<Karte> cardshandsorted = new ArrayList<>();
        cardshandsorted.add(new Karte(Farbe.KARO, Wert.SECHS));
        cardshandsorted.add(new Karte(Farbe.KARO, Wert.SIEBEN));
        cardshandsorted.add(new Karte(Farbe.KARO, Wert.ACHT));
        cardshandsorted.add(new Karte(Farbe.KARO, Wert.NEUN));
        cardshandsorted.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cardshandsorted.add(new Karte(Farbe.PIK, Wert.BUBE));
        cardshandsorted.add(new Karte(Farbe.KREUZ, Wert.DAME));

        cards2 = combinations.sort(cards2);
        for (Karte elem : cards2) {
            System.out.println(elem.toInt());
        }
    }

    @Test
    void isPair() {
        ArrayList<Karte> cards = new ArrayList<>();
        cards.add(new Karte(Farbe.KARO, Wert.ASS));
        cards.add(new Karte(Farbe.KARO, Wert.KOENIG));
        cards.add(new Karte(Farbe.KARO, Wert.DAME));
        cards.add(new Karte(Farbe.KARO, Wert.BUBE));
        cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
        assertEquals(true, combinations.isPair(cards));
    }

    @Test
    void isTwoPair() {
        //TODO
    }

    @Test
    void isThreeOfAKind() {
        ArrayList<Karte> cards = new ArrayList<>();
        cards.add(new Karte(Farbe.KARO, Wert.ASS));
        cards.add(new Karte(Farbe.KARO, Wert.KOENIG));
        cards.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
        cards.add(new Karte(Farbe.KARO, Wert.BUBE));
        cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
        assertEquals(true, combinations.isThreeOfAKind(cards));

        ArrayList<Karte> cards2 = new ArrayList<>();
        cards2.add(new Karte(Farbe.KARO, Wert.ASS));
        cards2.add(new Karte(Farbe.KARO, Wert.KOENIG));
        cards2.add(new Karte(Farbe.KARO, Wert.DAME));
        cards2.add(new Karte(Farbe.KARO, Wert.BUBE));
        cards2.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards2.add(new Karte(Farbe.PIK, Wert.ZEHN));
        assertEquals(false, combinations.isThreeOfAKind(cards2));
    }

    @Test
    void isStraight() {
        //TODO
    }
    
    @Test
    void isFlush() {
        //TODO
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

    @Test
    void isFourOfAKind() {
        ArrayList<Karte> cards = new ArrayList<>();
        cards.add(new Karte(Farbe.KARO, Wert.ASS));
        cards.add(new Karte(Farbe.KARO, Wert.KOENIG));
        cards.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
        cards.add(new Karte(Farbe.HERZ, Wert.ZEHN));
        cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
        assertEquals(true, combinations.isFourOfAKind(cards));

        ArrayList<Karte> cards2 = new ArrayList<>();
        cards2.add(new Karte(Farbe.KARO, Wert.ASS));
        cards2.add(new Karte(Farbe.KARO, Wert.KOENIG));
        cards2.add(new Karte(Farbe.KARO, Wert.DAME));
        cards2.add(new Karte(Farbe.KARO, Wert.BUBE));
        cards2.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards2.add(new Karte(Farbe.PIK, Wert.ZEHN));
        assertEquals(false, combinations.isFourOfAKind(cards2));
    }

    @Test
    void isStraightFlush() {
        ArrayList<Karte> cards2 = new ArrayList<>();
        cards2.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards2.add(new Karte(Farbe.PIK, Wert.ZEHN));
        cards2.add(new Karte(Farbe.KREUZ, Wert.ZEHN));
        cards2.add(new Karte(Farbe.KARO, Wert.NEUN));
        cards2.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards2.add(new Karte(Farbe.KARO, Wert.SIEBEN));
        cards2.add(new Karte(Farbe.KARO, Wert.SECHS));
        assertEquals(true, combinations.isStraightFlush(cards2));

        ArrayList<Karte> cards = new ArrayList<>();
        cards.add(new Karte(Farbe.KARO, Wert.ZEHN));
        cards.add(new Karte(Farbe.PIK, Wert.ZEHN));
        cards.add(new Karte(Farbe.KREUZ, Wert.ASS));
        cards.add(new Karte(Farbe.KARO, Wert.NEUN));
        cards.add(new Karte(Farbe.KARO, Wert.ACHT));
        cards.add(new Karte(Farbe.KARO, Wert.SIEBEN));
        cards.add(new Karte(Farbe.KARO, Wert.DREI));
        assertEquals(false, combinations.isStraightFlush(cards));

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
}
