package com.progamierbeleg.programierbeleg;

public class Spielkreisnode {

    private Spieler p;
    private Spielkreisnode naechster;

    public Spielkreisnode(Spieler p, Spielkreis sp) {
        this.p = p;
        naechster = sp.getentry() ;
    }

    public Spieler getP() {
        return p;
    }

    public void setP(Spieler p) {
        this.p = p;
    }

    public Spielkreisnode getNaechster() {
        return naechster;
    }

    public void setNaechster(Spielkreisnode naechster) {
        this.naechster = naechster;
    }

    
}
