package com.progamierbeleg.programierbeleg.Karten;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    /**
     * Arraylist um alle Karten des Decks zu halten
     */
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Karte> deck;
    Random r;
    /**
     * Constructor der ein Standart 52 Kartendeck erstellt 
     */
    public DeckOfCards() {
        deck = new ArrayList<>();
        r = new Random();
        for (Karte.Farbe f : Karte.Farbe.values()) {
            for (Karte.Wert w : Karte.Wert.values()) {
                deck.add(new Karte(f, w));
            }
        }
    }

    /**
     * Gibt eine Zufaellige Karte aus dem Deck aus und entfernt diese aus dem Deck
     * @return Karte eine zufaellige Karte aus dem Deck
     */
    public Karte deal() {
        int pick = r.nextInt(getdeck().size());
        Karte dealt = getdeck().get(pick);
        getdeck().remove(pick);
        return dealt;
    }

    /**
     * "verbrennt" die oberste Karte des Decks
     */
    public void burn(){
        deal();
    }

    /**
     *  Gibt das Deck zurueck
     * @return deck 
     */
    private ArrayList<Karte> getdeck() {
        return deck;
    }

}
