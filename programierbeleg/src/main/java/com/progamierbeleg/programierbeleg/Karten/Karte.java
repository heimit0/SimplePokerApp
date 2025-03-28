package com.progamierbeleg.programierbeleg.Karten;

import java.lang.classfile.instruction.SwitchCase;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.flow.component.html.Image;

/*
 * Bietet Grundfunktionalitaet um Karten und ihre Sprites zu generieren
 */
public class Karte {

    /*
     * Enum um moegliche Farben der Karten bereitszustellen
     */
    enum Farbe {
        KARO, HERZ, PIK, KREUZ
    }

    /*
     * Enum um moegliche Werte der Karten bereitszustellen
     */
    enum Wert {
        ZWEI, DREI, VIER, FUENF, SECHS, SIEBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KOENIG, ASS
    }
    private Farbe f; 
    private Wert w;

    public Karte(Farbe f, Wert w) {
        this.f = f;
        this.w = w;
    }
    
    /*
     * Findet das passende Sprite zu einer beliebigen Karte und gibt es zurueck
     */
    public String getSprite() {
        return "ressources/Images/" + getFarbe() + "_" + getWert() + ".png";
    }
    
    /*
     * gibt die Farbe der Karte zurueck
     */
    public Farbe getFarbe() {
        return f;
    }

    /*
     * gibt den Wert der Karte zurueck
     */
    public Wert getWert() {
        return w;
    }

}
