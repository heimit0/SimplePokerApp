package com.progamierbeleg.programierbeleg;



public class Spielkreis {

    private Spielkreisnode entry;
    Spielkreisnode current;
    private int size;
    

    Spielkreis() {
        size = 0;
    }

    public void add(Spieler p) {
        Spielkreisnode skn = new Spielkreisnode(p, this);
        if (size == 0) {
            entry = skn;
            current = skn;
        }
        else {
            current.setNaechster(skn);
            current = current.getNaechster();
        }
        size++;
    }
    

    public Spielkreisnode getcurrent() {
        return current;
    }

    public Spielkreisnode getnaechster() {
        return current.getNaechster();
    }

    public Spielkreisnode getentry() {
        return entry;
    }

    public int getsize() {
        return size;
    }




}
