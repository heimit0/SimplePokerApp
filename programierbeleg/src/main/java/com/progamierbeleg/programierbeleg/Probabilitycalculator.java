package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;

import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.Karten.combinations;

/*
 * Errechnet die Wahrscheinlichkeit fuer Karten Kombination
 */
public abstract class Probabilitycalculator {

    public static int calculateProbability(Spiel s, Spieler spieler, ArrayList<Karte> Tisch) {

        switch (s.getSp()) {
            case PREFLOP:
                calculatePreflopProbability(s, spieler, Tisch);
                break;

            case FLOP:
                calculateFlopProbability(s, spieler, Tisch);
                break;

            case TURN:
                calculateTurnProbability(s, spieler, Tisch);
                break;

            case RIVERS:
                calculateRiversProbability(s, spieler, Tisch);
                break;
        }

        return 0;
    }

    public static int calculatePreflopProbability(Spiel s, Spieler spieler, ArrayList<Karte> Tisch) {
       // if (spieler.getHand().get(0).getWert()==spieler.getHand().get(1).getWert())
        //{
         //   return (int) (Math.random()*40 + 10);
        //}
        return 100;
    }

    public static int calculateFlopProbability(Spiel s, Spieler spieler, ArrayList<Karte> Tisch) {
        return 100;
    }

    public static int calculateTurnProbability(Spiel s, Spieler spieler, ArrayList<Karte> Tisch) {
        return 100;
    }

    public static int calculateRiversProbability(Spiel s, Spieler spieler, ArrayList<Karte> Tisch) {
        return combinations.getCombination(spieler.getHand(), Tisch);
    }


}

