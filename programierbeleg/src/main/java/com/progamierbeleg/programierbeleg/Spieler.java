package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;
import com.progamierbeleg.programierbeleg.Karten.Karte;

public class Spieler {

    private int geld;
    private ArrayList<Karte> hand;

    public Spieler() {
        geld = 1000;
        hand = new ArrayList<>();
    }

    public int getGeld() {
        return geld;
    }

    public void addGeld(int geld) {
        this.geld += geld;
    }

    public void SetzeGeld(int geld) {
        this.geld -= geld;
    }

    public ArrayList<Karte> getHand() {
        return hand;
    }

    public void setHand(int pos, Karte k) {
        hand.set(pos, k);
    }

}
