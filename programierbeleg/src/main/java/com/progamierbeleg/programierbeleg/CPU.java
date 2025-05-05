package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;

import com.progamierbeleg.programierbeleg.views.PokerView;

public class CPU extends Spieler {

    

    public CPU(Spiel spiel) {
        super(spiel);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void turn(PokerView view) {

        if (getFolded() || allin)
            return;

        int action = Probabilitycalculator.calculateProbability(view.getS(), this, getHand());
        switch (action) {
            case -1:
                check();
                break;

            case -99:
                setFolded(true);
                break;

            default:
                if (action < 1) {
                    System.err.println("Wert muss pos sein");
                }
                if (action >= geld) {
                    allin();
                }
                raiseAmmount(action - view.getS().getlastbet());
                break;
        }
    }





}
