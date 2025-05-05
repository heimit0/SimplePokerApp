package com.progamierbeleg.programierbeleg;

import java.util.ArrayList;
import com.progamierbeleg.programierbeleg.Karten.Karte;
import com.progamierbeleg.programierbeleg.views.PokerView;

public class Spieler {

    protected int geld;
    private int maxwin;
    private ArrayList<Karte> hand;
    private int BetAmmount;
    private boolean isTurn;
    private boolean folded;
    protected boolean allin;
    protected Spiel s;
    private enum Status {
      RAISE,CHECK,FOLD,MATCH  
    };
    
    public enum playerstatus {
        RAISED, CHECKED, FOLDED
    };

    private Status currentStatus;

    public Spieler(Spiel spiel) {
        geld = 1000;
        hand = new ArrayList<>();
        s = spiel;
        allin = false;
    }

    

  

    public void raiseAmmount(int raise) {
        geld -= raise + s.getlastbet();
        s.getTisch().addtooPot(raise + s.getlastbet());
        s.setlastbet(s.getlastbet()+raise);
    }

    public void check() {

    }
    
    public void call() {
        
    }

    public void fold() {

    }
    
    public void allin() {
        allin = true;
        raiseAmmount(BetAmmount);
        maxwin = s.getTisch().getPot();
    }

   

    public void addHand(Karte k) {
        hand.add(k);
    }

    public void turn(PokerView view)  {

        if (getFolded() || allin)
            return;
        
        int action = view.getMSpielerAction();

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
                raiseAmmount(action - s.getlastbet());
                break;
        }
        view.player.playeracted = false;

    }

    public ArrayList<Karte> getHand() {
        return hand;
    }
    
    public int getBetAmmount() {
        return BetAmmount;
    }

    public boolean getFolded() {
        return folded;
    }

    public void setFolded(boolean f) {
        folded = f;
    }

    public void setBetAmmount(int betAmmount) {
        BetAmmount = betAmmount;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getGeld() {
        return geld;
    }

    public void addGeld(int geld) {
        this.geld += geld;
    }
}
