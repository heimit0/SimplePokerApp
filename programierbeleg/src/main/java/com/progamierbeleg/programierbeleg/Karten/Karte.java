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

        /** 
        Map<Wert, Image> spriteskaro = new HashMap<Wert, Image>();
        Map<Wert, Image> spritesherz = new HashMap<Wert, Image>();
        Map<Wert, Image> spritespik = new HashMap<Wert, Image>();
        Map<Wert, Image> spriteskreuz = new HashMap<Wert, Image>();
        
        Map<Farbe, Map<Wert, Image>> spritescolor = new HashMap<Farbe,Map<Wert,Image>>();
         
        spritescolor.put(Farbe.KARO, spriteskaro);
        spritescolor.put(Farbe.HERZ, spritesherz);
        spritescolor.put(Farbe.PIK, spritespik);
        spritescolor.put(Farbe.KREUZ, spriteskreuz);
        
        spriteskaro.put(Wert.ZWEI, karozwei.png);
        spriteskaro.put(Wert.DREI, karozwei.png);
        spriteskaro.put(Wert.VIER, karozwei.png);
        spriteskaro.put(Wert.FUENF, karozwei.png);
        spriteskaro.put(Wert.SECHS, karozwei.png);
        spriteskaro.put(Wert.SIEBEN, karozwei.png);
        spriteskaro.put(Wert.ACHT, karozwei.png);
        spriteskaro.put(Wert.NEUN, karozwei.png);
        spriteskaro.put(Wert.ZEHN, karozwei.png);
        spriteskaro.put(Wert.BUBE, karozwei.png);
        spriteskaro.put(Wert.DAME, karozwei.png);
        spriteskaro.put(Wert.KOENIG, karozwei.png);
        spriteskaro.put(Wert.ASS, karozwei.png);
        
        **/

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
