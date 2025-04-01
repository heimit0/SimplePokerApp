package com.progamierbeleg.programierbeleg.Karten;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    /*
     * Arraylist um alle Karten des Decks zu halten
     */
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Karte> deck;
    Random r;
    /*
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

    /*
     * Gibt eine Zufaellige Karte aus dem Deck aus und entfernt diese aus dem Deck
     */
    public Karte deal() {
        int pick = r.nextInt(51);
        Karte dealt = getdeck().get(pick);
        getdeck().remove(pick);
        return dealt;
    }

    public void burn(){
        int pick = r.nextInt(51);
        getdeck().remove(pick);
    }

    private ArrayList<Karte> getdeck() {
        return deck;
    }

}
