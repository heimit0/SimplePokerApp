package com.progamierbeleg.programierbeleg;

import com.progamierbeleg.programierbeleg.views.PokerView;

public class Spiel {

    public enum spielphase {
        PREFLOP, FLOP, TURN, RIVERS
    };

    private MenschlicherSpieler MSpieler;
    private CPU[] CPUarr;
    private Tisch tisch;
    private Spieler smallblind;
    private Spieler bigblind;
    private spielphase currentsp;
    private int raiseammount;
    private int lastbet;
    private Spielkreis spielkreis;
    private Spielkreisnode activePosition;
    PokerView view;
    volatile Boolean waitforplayer;

    /**
     * Erstellt eine Instanz von Spiel
     * Erstellt alle Spieler und den Tisch
     */
    public Spiel(PokerView view) {
        MSpieler = new MenschlicherSpieler(this);
        CPUarr = new CPU[3];
        spielkreis = new Spielkreis();
        spielkreis.add(MSpieler);
        this.view = view;
        waitforplayer = false;

        for (int i = 0; i < CPUarr.length; i++) {
            CPUarr[i] = new CPU(this);
            spielkreis.add(CPUarr[i]);
        }
        tisch = new Tisch();
        smallblind = spielkreis.getcurrent().getP();
        bigblind = spielkreis.getcurrent().getP();
        activePosition = spielkreis.getcurrent();

    }

    /**
     * Simuliert eine Runde eines Pokerspiels
     * 
     */
    public void spielerunde() {
        smallblind.raiseAmmount(5);
        bigblind.raiseAmmount(5);
        preflop();
        view.player.updateKartenSprite();
        view.other1.updateKartenSprite();
        view.other2.updateKartenSprite();
        view.other3.updateKartenSprite();
        view.tableview.updateKartenSprite();
        actionround();

    }

    /**
     * Simuliert eine Wet runde aller Spieler
     * 
     */
    private void actionround() {

        boolean some1raised = false;

        for (int i = 0; i < 4; i++) {
            int lastbettemp = getlastbet();

            if (activePosition.getP().getClass() == MenschlicherSpieler.class) {

            }
            activePosition.getP().turn(view);


            activePosition = activePosition.getNaechster();
            if (lastbet != lastbettemp) {
                some1raised = true;
                lastbettemp = lastbet;
            }
        }
        if (some1raised) {
            actionround();

        }
    }
       
    


    /**
     * Wird in View aufgerufen um Variable weiterzugeben
     * @param raise
     */
    public void getRaiseAmmountFromView(int raise) {
        raiseammount = raise;
    }

    /**
     * Ueberprueft ob ein Spieler kein Geld mehr hat
     * @return bool ob ein Spieler geld hat
     */
    public boolean isbankrupt() {
        for (int i = 0; i <= 4; i++) {
            if (spielkreis.getnaechster().getP().getGeld() <= 0)
                return true;
        }
        return false;
    }

    /**
     * Startet die Spielphase Preflop
     * -> Gibt 2 Karten auf die hand von allen Spielern
     */
    public void preflop() {
        currentsp = spielphase.PREFLOP;
        MSpieler.addHand(tisch.getDeck().deal());
        MSpieler.addHand(tisch.getDeck().deal());
        tisch.getDeck().burn();
        for (int i = 0; i < 8; i++) {
            spielkreis.current.getP().addHand(tisch.getDeck().deal());
        }

        view.player.updateKartenSprite();
    }

    /**
     * Startet die Spielphase Flop
     * -> Gibt 3 Karten offen an den Tisch
     */
    public void flop() {
        tisch.getDeck().burn();
        tisch.addtotable(tisch.getDeck().deal());
        tisch.addtotable(tisch.getDeck().deal());
        tisch.addtotable(tisch.getDeck().deal());
        currentsp = spielphase.TURN;
    }

    /**
     * Startet die Spielphase turn
     * -> Gibt eine Karte offen an den Tisch
     */
    public void turn() {
        tisch.getDeck().burn();
        tisch.addtotable(tisch.getDeck().deal());
        currentsp = spielphase.RIVERS;
    }

    /**
     * Startet die Spielphase rivers
     * -> Gibt eine Karte offen an den Tisch
     */
    public void rivers() {
        tisch.getDeck().burn();
        tisch.addtotable(tisch.getDeck().deal());
        currentsp = spielphase.PREFLOP;
    }

    public MenschlicherSpieler getMSpieler() {
        return MSpieler;
    }

    public CPU[] getCPUarr() {
        return CPUarr;
    }

    public Tisch getTisch() {
        return tisch;
    }

    public int getlastbet() {
        return lastbet;
    }

    public void setlastbet(int lb) {
        lastbet = lb;
    }

    public Spieler getSmallblind() {
        return smallblind;
    }

    public Spieler getBigblind() {
        return bigblind;
    }

    public spielphase getSp() {
        return currentsp;
    }

    public Spieler getactivePLayer() {
        return activePosition.getP();
    }

    public Spielkreis getspielkreis() {
        return spielkreis;
    }

}
