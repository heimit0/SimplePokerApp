package com.progamierbeleg.programierbeleg.views;

import com.progamierbeleg.programierbeleg.MenschlicherSpieler;
import com.progamierbeleg.programierbeleg.Spieler;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;

/**
 * Klasse fuer die GUI Elemente des Spielers
 */
public class PlayerView extends VerticalLayout {
    private Image Karte1;
    private Image Karte2;
    private NumberField raiseAmmount;
    
    private int MSpielerAction;
    private MenschlicherSpieler MSpieler;
    private HorizontalLayout Karten;
    private Paragraph geldDisplay;

    private H2 actionAnnouncerDisplay;

    public volatile boolean playeracted;

/**
 * Konstruktor
 * @param Mspieler Der Spieler zu dem die GUI Elemente gehoeren
 */
    public PlayerView(MenschlicherSpieler Mspieler) {
        this.MSpieler = Mspieler;
        
        playeracted = true;

        actionAnnouncerDisplay = new H2();

        VerticalLayout CardsButtonsContainer = new VerticalLayout();
        HorizontalLayout cards = new HorizontalLayout();
        HorizontalLayout buttonsplayer = new HorizontalLayout();

        Button check = new Button("Check");
        Button raiseconfirm = new Button("Raise");
        Button fold = new Button("Fold");

        geldDisplay = new Paragraph("Credits: "+Mspieler.getGeld());

        cards.setWidthFull();

        Karten = new HorizontalLayout();
        add(Karten);

        Karten.setWidthFull();
        Karten.setAlignItems(Alignment.CENTER);
        Karten.setJustifyContentMode(JustifyContentMode.CENTER);

        

        raiseAmmount = new NumberField("Raise Ammount");
        raiseAmmount.setStepButtonsVisible(true);
        raiseAmmount.setMax(Mspieler.getGeld());
        raiseAmmount.setMin(1);
        raiseAmmount.setStep(1);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.add(check);
        buttons.add(raiseAmmount);
        buttons.add(raiseconfirm);
        buttons.add(fold);

        add(buttons);

        add(geldDisplay);
       

        cards.setWidthFull();
        buttonsplayer.setWidthFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        cards.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        buttonsplayer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        CardsButtonsContainer.add(cards);
        

        check.addClickListener(e -> {
            MSpielerAction = 0;
            playeracted = true;
        });
        raiseconfirm.addClickListener(e -> {
            MSpielerAction = (int) Math.round(raiseAmmount.getValue());
            playeracted = true;
            
        });
        fold.addClickListener(e -> {
            MSpielerAction = -1;
            playeracted = true;
        });
    }
    
    /**
     * Updated die Karten sprites
     */
    public void updateKartenSprite() {
        Karten.removeAll();
        Karte1 = new Image(MSpieler.getHand().get(0).getSprite(), "alt");
        Karte2 = new Image(MSpieler.getHand().get(1).getSprite(), "alt");
        Karte1.setHeight("80px");
        Karte2.setHeight("80px");
        Karten.add(Karte1);
        Karten.add(Karte2);

    }

    /**
     * Updated das GUI Element das dass uebrige Geld anzeigt
     */
    
    public void updateGeldDisplay(){
        remove(geldDisplay);
        geldDisplay.setText("Credits: "+MSpieler.getGeld());
        add(geldDisplay);
    }
    /**
     * 
     * @return MSpielerAction gibt die aktion des Spielers zurueck
     */
    public int getMSpielerAction() {
        return MSpielerAction;
    }

    public void setactiondisplay(Spieler.playerstatus playerstatus) {
        actionAnnouncerDisplay.setText(playerstatus + "");
        add(actionAnnouncerDisplay);
    }
}
