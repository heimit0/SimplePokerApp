package com.progamierbeleg.programierbeleg;

import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.Karten.combinations;
import com.progamierbeleg.programierbeleg.Spiel.spielphase;

public class Spiel {

    enum spielphase {
        PREFLOP, FLOP, TURN, RIVERS
    };

    private MenschlicherSpieler MSpieler;
    private CPU[] CPUarr;
    private Tisch tisch;
    private int runde;
    private Spieler smallblind;
    private Spieler bigblind;
    private spielphase sp;
    private final Spieler[] Runde;
    

    public Spiel() {
        MSpieler = new MenschlicherSpieler();
        Runde = new Spieler[4];
        Runde[0] = MSpieler;
        CPUarr = new CPU[3];
        int i = 1;
        for (CPU cpu : CPUarr) {
            cpu = new CPU();
            Runde[i] = cpu;
            i++;
        }
        tisch = new Tisch();

    }
    
    public void bettinground() {

    }
    
    public boolean isbankrupt() {
        for (Spieler s : Runde) {
            if (s.getGeld() <= 0)
                return true;
        }
        return false;
    }

    public void ganzerunde() {
        int blinddet = 0;
        sp = spielphase.PREFLOP;
        for (int rundeno = 0; !isbankrupt(); rundeno++) {
            switch (blinddet % 4) {
                case 3 -> {
                    smallblind = Runde[3];
                    bigblind = Runde[0];
                    blinddet++;
                }
                default -> {
                    smallblind = Runde[blinddet];
                    bigblind = Runde[blinddet+1];
                    blinddet++;
                }
            }
            for (int i = 0; i <= 4; i++) {
                switch (sp) {
                    case PREFLOP -> preflop();
                    case FLOP -> flop();
                    case TURN -> turn();
                    case RIVERS -> rivers();
                }
                bettinground();
            }
            
            for(Spieler s : Runde){
                combinations.getCombination(s.getHand(), tisch.gettable());
            }
        }
    }

    public void preflop() {
        MSpieler.setHand(0, tisch.getDeck().deal());
        MSpieler.setHand(1, tisch.getDeck().deal());

        for (CPU c : CPUarr) {
            c.setHand(0, tisch.getDeck().deal());
            c.setHand(1, tisch.getDeck().deal());
        }
        sp = spielphase.FLOP;

    }
    
    public void flop() {
        tisch.getDeck().burn();
        for (int i = 0; i <= 3; i++) {
           tisch.addtotable(tisch.getDeck().deal()); 
        }
        sp = spielphase.TURN;
    }
    
    public void turn() {
        tisch.getDeck().burn();
        tisch.addtotable(tisch.getDeck().deal());
        sp = spielphase.RIVERS;
    }

    public void rivers() {
        tisch.getDeck().burn();
        tisch.addtotable(tisch.getDeck().deal());
        sp = spielphase.PREFLOP;
    }
    

}
