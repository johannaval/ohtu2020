package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.*;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Komento komento;
    private Map<Button, Komento> komennot;
    private Komento edellinen = null;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new HashMap<Button, Komento>();
        this.nollaa = nollaa;
        this.plus = plus;
        this.miinus = miinus;
        this.undo = undo;
        komennot.put(plus, new Summaa(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(miinus, new Erotus(tuloskentta, syotekentta, nollaa, undo, sovellus));
        komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, nollaa, undo, sovellus));
    }

    @Override
    public void handle(Event event) {

        if (event.getTarget() != undo && event.getTarget() != nollaa) {

            try {
                Integer.parseInt(this.syotekentta.getText());
                Komento komento = komennot.get((Button) event.getTarget());
                komento.suorita();
                this.edellinen = komento;

            } catch (NumberFormatException ex) {
            }

        } else if (event.getTarget() == nollaa) {
            Komento komento = komennot.get((Button) event.getTarget());
            komento.suorita();

        } else {
            this.edellinen.peru();
            this.edellinen = null;
        }
    }
}