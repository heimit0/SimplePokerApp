package com.progamierbeleg.programierbeleg.Karten;

import java.util.ArrayList;

import com.progamierbeleg.programierbeleg.Karten.Karte.Farbe;
import com.progamierbeleg.programierbeleg.Karten.Karte.Wert;

public abstract class combinations {

    private enum allcombinations {
        HIGHCARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH,
        ROYAL_FLUSH
    };

    public static int getCombination(Karte[] hand, Karte[] table) {
        int value = 1;
        ArrayList<Karte> allcards = new ArrayList<>();
        allcards.add(hand[0]);
        allcards.add(hand[1]);
        allcards.add(table[0]);
        allcards.add(table[1]);
        allcards.add(table[2]);
        allcards.add(table[3]);
        allcards.add(table[4]);

        if (isRoyalFlush(allcards)) {
            value = 10;
        } else if (isStraightFlush(allcards)) {
            value = 9;
        } else if (isFourOfAKind(allcards)) {
            value = 8;
        } else if (isFullHouse(allcards)) {
            value = 7;
        } else if (isFlush(allcards)) {
            value = 6;
        } else if (isStraight(allcards)) {
            value = 5;
        } else if (isThreeOfAKind(allcards)) {
            value = 4;
        } else if (isTwoPair(allcards)) {
            value = 3;
        } else if (isPair(allcards)) {
            value = 2;
        } else {
            value = 1;
        }
        return value;
    }

    public static boolean isSameColor(ArrayList<Karte> cards) {
        Farbe color = cards.get(0).getFarbe();
        for (Karte k : cards) {
            if (k.getFarbe() != color) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Karte> sort(ArrayList<Karte> cards) {
        ArrayList<Karte> sorted = new ArrayList<>();
        int size = cards.size();
        for (int i = 0; i < size; i++) {
            Karte smallest = cards.get(0);
            for (int j = 0; j < size-i; j++) {
                if (cards.get(j).toInt() < smallest.toInt())
                    smallest = cards.get(j);
            }
            sorted.add(smallest);
            cards.remove(smallest);
        }
        return sorted;
        /* 
          for (int i = 1; i < cards.size(); i++) {
          for (int j = 0; j < cards.size(); j++) {
              if (cards.get(j).toInt() > cards.get(i).toInt()) {
                  Karte memKarte = cards.get(i);
                  cards.set(i, cards.get(j));
                  cards.set(j, memKarte);
              }
          }
          }
          
          return cards;
        
          */
    }
    public static boolean isRoyalFlush(ArrayList<Karte> cards) {
        ArrayList<Karte> royalFlush = new ArrayList<>();
        for (Karte k : cards) {
            if (k.getWert() == Wert.ASS || k.getWert() == Wert.KOENIG || k.getWert() == Wert.DAME
                    || k.getWert() == Wert.BUBE || k.getWert() == Wert.ZEHN) {
                royalFlush.add(k);
            }
        }
        return (royalFlush.size() >= 5 && isSameColor(royalFlush));
    }

    public static boolean isStraightFlush(ArrayList<Karte> cards) {
        cards = sort(cards);
        ArrayList<Karte> selected = new ArrayList<>();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).toInt() == cards.get(i - 1).toInt() - 1) {
                selected.add(cards.get(i - 1));
            } else {
                selected.clear();
            }
            if (selected.size() >= 4 && isSameColor(selected))
                return true;

        }
        return false;
    }

    public static boolean isFourOfAKind(ArrayList<Karte> cards) {
        int counter = 0;
        cards = sort(cards);
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i; j < cards.size(); j++) {
                if (cards.get(i).toInt() == cards.get(j).toInt()) {
                    counter++;
                }
                if (counter >= 4) {
                    return true;
                }
            }
            counter = 0;
        }
        return false;
    }

    public static boolean isThreeOfAKind(ArrayList<Karte> cards) {
        int counter = 0;
        cards = sort(cards);
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i; j < cards.size(); j++) {
                if (cards.get(i).toInt() == cards.get(j).toInt()) {
                    counter++;
                }
                if (counter >= 3) {
                    return true;
                }
            }
            counter = 0;
        }
        return false;
    }

    public static boolean isPair(ArrayList<Karte> cards) {
        int counter = 0;
        cards = sort(cards);
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i; j < cards.size(); j++) {
                if (cards.get(i).toInt() == cards.get(j).toInt()) {
                    counter++;
                }
                if (counter >= 2) {
                    return true;
                }
            }
            counter = 0;
        }
        return false;
    }

    public static boolean isFullHouse(ArrayList<Karte> cards) {
        boolean dreier = false;
        ArrayList<Karte> geprueft = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            geprueft.add(cards.get(i));
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getWert() == cards.get(j).getWert()) {
                    geprueft.add(cards.get(j));
                }
            }
            if (geprueft.size() >= 3) {
                dreier = true;
                for (Karte karte : geprueft) {
                    cards.remove(karte);
                }
            }
            geprueft.clear();

        }
        for (int i = 0; i < cards.size(); i++) {
            geprueft.add(cards.get(i));
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getWert() == cards.get(j).getWert()) {
                    geprueft.add(cards.get(j));
                }
            }
            if (geprueft.size() >= 2 && dreier) {
                return true;
            }
            geprueft.clear();
        }

        return false;
    }

    public static boolean isFlush(ArrayList<Karte> cards) {

        return false;
    }

    public static boolean isStraight(ArrayList<Karte> cards) {

        return false;
    }

    public static boolean isTwoPair(ArrayList<Karte> cards) {

        return false;
    }

}
