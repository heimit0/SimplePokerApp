package com.progamierbeleg.programierbeleg.Karten;



/*
 * Bietet Grundfunktionalitaet um Karten und ihre Sprites zu generieren
 */
public class Karte {

    /*
     * Enum um moegliche Farben der Karten bereitszustellen
     */
    public enum Farbe {
        KARO, HERZ, PIK, KREUZ
    }

    /*
     * Enum um moegliche Werte der Karten bereitszustellen
     */
    public enum Wert {
        ZWEI, DREI, VIER, FUENF, SECHS, SIEBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KOENIG, ASS
    }
    private final  Farbe f; 
    private final Wert w;


    /*
     * Konstruktor fuer die Klasse karte
     */
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
        if (this == null)
            return null;
        return w;
    }
    
    /*
     * determines wether a card has a certain value thats given as a param
     * is(Farbe, Wert)
     */
    public boolean is(Farbe f, Wert w) {
        return (this.getFarbe() == f && this.getWert() == w);
    }
    
    /*
     * Konvertiert die Enum zu einem passenden Int-Wert
     */
    public int toInt() {
        return switch (this.getWert()) {
            case ZWEI -> 2;
            case DREI -> 3;
            case VIER -> 4;
            case FUENF -> 5;
            case SECHS -> 6;
            case SIEBEN -> 7;
            case ACHT -> 8;
            case NEUN -> 9;
            case ZEHN -> 10;
            case BUBE -> 11;
            case DAME -> 12;
            case KOENIG -> 13;
            case ASS -> 14;
            default -> -1;
        };
    }

}
