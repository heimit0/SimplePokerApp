package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;

import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.Karten.DeckOfCards;


public class Tisch {
    @SuppressWarnings("FieldMayBeFinal")
    private DeckOfCards deck;
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Karte> table;
    private int pot;

    public Tisch() {
        table = new ArrayList<>();
        pot = 0;
        deck = new DeckOfCards();
    }

    public DeckOfCards getDeck() {
        return deck;
    }

    public void addtotable(Karte k) {
        table.add(k);
    }

    public ArrayList<Karte> gettable() {
        return table;
    }




}
