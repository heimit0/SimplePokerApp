package com.progamierbeleg.programierbeleg.views;

import com.progamierbeleg.programierbeleg.Spieler;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


/**
 * Klasse fuer die GUI Elemente der gegenspieler
 */
public class OpponentsView extends HorizontalLayout {
    
    Image Karte1;
    Image Karte2;
    Spieler spieler;
    Text gelddisplay;

    /**
     * Konstruktor der die Karten Images erstellt
     * @param sp Spieler zudem das GUI Element gehoert
     */
    public OpponentsView(Spieler sp) {
        spieler = sp;
        
        Karte1 = new Image();
        Karte2 = new Image();
        Karte1.setHeight("80px");
        Karte2.setHeight("80px");
        add(Karte1);
        add(Karte2);
        gelddisplay = new Text(spieler.getGeld() + "");

        setSpacing("20px");
        setWidth("30%");

    }

    /**
     * Updated die Sprites der Karten 
     */
    public void updateKartenSprite() {
        removeAll();
        Karte1 = new Image("KARTEN_SPRITES/RUECKSEITE.png", "alt");
        Karte2 = new Image("KARTEN_SPRITES/RUECKSEITE.png", "alt");
        Karte1.setHeight("80px");
        Karte2.setHeight("80px");
        add(Karte1);
        add(Karte2);
    }

    /**
     * Updated das GUI Element das dass uebrige Geld anzeigt
     */
    public void updateGeldDisplay() {
        remove(gelddisplay);
        gelddisplay.setText(spieler.getGeld() + "");
        add(gelddisplay);
    }

}
