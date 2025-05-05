package com.progamierbeleg.programierbeleg.views;

import java.util.ArrayList;


import com.progamierbeleg.programierbeleg.Spiel;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;



@Route("PokerView")
public class PokerView extends VerticalLayout {
    enum spielphase {
        PREFLOP, FLOP, TURN, RIVERS
    };
    
    /*
     * SpielLogik geschieht im erzeugten Spiel s
     */
    Spiel s;

    ArrayList<Image> tischImages;
    
    /*
     * Layouts der anderen Spieler
     */
    public OpponentsView other1;
    public OpponentsView other2;
    public OpponentsView other3;

    int phasecounter;

    private int MSpielerAction;

    public H2 spieldisplay;

    public boolean isTurn;

    public NumberField raiseAmmount;

    private spielphase spielphase;

    public TableView tableview;
   
    public PlayerView player;

    public PokerView() throws InterruptedException {

        setSizeFull();

        phasecounter = 0;
        spielphase = spielphase.PREFLOP;

        s = new Spiel(this);

        spieldisplay = new H2("Spielphase: " + spielphase);

        tableview = new TableView(s.getTisch(), this);

        player = new PlayerView(s.getMSpieler());

        /*
         * Erstellung und Einbindung der 3 gegenspieler
         */
        HorizontalLayout others = new HorizontalLayout();
         other1 = new OpponentsView(s.getCPUarr()[0]);
         other2 = new OpponentsView(s.getCPUarr()[1]);
         other3 = new OpponentsView(s.getCPUarr()[2]);

         others.add(other1);
         others.add(other2);
         others.add(other3);

         others.setJustifyContentMode(JustifyContentMode.CENTER);
         others.setAlignItems(Alignment.CENTER);
         others.setWidthFull();

        add(spieldisplay);
        add(others);
        add(tableview);
        add(player);

       s.spielerunde();
    }
    
    public int getMSpielerAction() {
        return MSpielerAction;
    }

    public Spiel getS() {
        return s;
    }
    
}
