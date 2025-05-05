package com.progamierbeleg.programierbeleg.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


/**
 * Start Bildschirm von dem Man aus das Spiel starten kann
 */
@Route("")
public class HomeView extends VerticalLayout {
    
    public HomeView() {
        setWidthFull();
        HorizontalLayout image = new HorizontalLayout();
        //add(new H1("ProgrammmierBeleg PokerSpiel"));
        image.add(new Image("POKER.png", "Pokerbild"));
        add(image);
        image.setJustifyContentMode(JustifyContentMode.CENTER);
        image.setWidthFull();
        Button b = new Button("Starte Spiel"); 

        b.addClickListener( e -> {
            UI.getCurrent().navigate(PokerView.class);
            
        });
        HorizontalLayout buttonlay = new HorizontalLayout();
        add(buttonlay);
        buttonlay.add(b);
        buttonlay.setWidthFull();
        buttonlay.setJustifyContentMode(JustifyContentMode.CENTER);

        add(new Paragraph(
                "Poker ist ein beliebtes Kartenspiel das seit den 19. Jahrhundert gespielt wird. In dieser Version wird Texas Hold'Em gepsielt"));
        add(new Paragraph(
                "Als Spieler startet man mit 1000Punkten die man Setzen kann, wenn ein Spieler keine Punkte mehr hat wird das Spiel beendet"));
        add(new Paragraph(
                "Die Sprites fuer die Pokerkarten stammen aus dem \"(Pixel) Poker Cards\" asset pack von Ivory Red "));
        add(new Paragraph("Nutzung unter https://creativecommons.org/licenses/by/4.0/ "));
    }
}
