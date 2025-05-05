package com.progamierbeleg.programierbeleg.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.progamierbeleg.programierbeleg.Spiel;
import com.progamierbeleg.programierbeleg.Tisch;
import com.progamierbeleg.programierbeleg.Spiel.spielphase;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * Klasse fuer die GUI Elemente des tables
 */
public class TableView extends HorizontalLayout {

    ArrayList<Image> tischImages;
    private Image communitycard1;
    private Image communitycard2;
    private Image communitycard3;
    private Image communitycard4;
    private Image communitycard5;

    H1 potdisplay;

    private Tisch t;
    private PokerView v;
    private Spiel s;


    public TableView(Tisch t, PokerView v) {
        this.v = v;
        this.t = t;
        s = v.getS();
        setHeight("100px");
        setWidthFull();
        tischImages = new ArrayList<>();
        Image deck = new Image("KARTEN_SPRITES/DECK.png", "Deck");
        add(deck);
        setAlignSelf(Alignment.CENTER);

        Div spacer = new Div();
        spacer.setWidth("200px");
        spacer.setHeight("100px");
        add(spacer);

        communitycard1 = new Image();
        communitycard2 = new Image();
        communitycard3 = new Image();
        communitycard4 = new Image();
        communitycard5 = new Image();
        add(communitycard1, communitycard2, communitycard3, communitycard4, communitycard5);

        potdisplay = new H1("Pot: "+t.getPot());
        addToEnd(potdisplay);
    }

    public void updateKartenSprite() {
        remove(communitycard1, communitycard2, communitycard3, communitycard4, communitycard5, potdisplay);
        
        Map<Spiel.spielphase,Integer> phasetoint = new HashMap<>();
        phasetoint.put(spielphase.PREFLOP, 0);
        phasetoint.put(spielphase.FLOP, 1);
        phasetoint.put(spielphase.RIVERS, 2);
        phasetoint.put(spielphase.TURN, 3);

        for (int i = 0; i < phasetoint.get(s.getSp()); i++) {
            communitycard1.setSrc(t.gettable().get(i).toString());
        }
        potdisplay.setText("Pot: "+t.getPot());
        add(communitycard1, communitycard2, communitycard3, communitycard4, communitycard5);
        addToEnd(potdisplay);
    }
}
