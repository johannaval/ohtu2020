package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento {

    private int arvoNyt;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {

        this.arvoNyt = Integer.valueOf(this.tuloskentta.getText());
        int syote = Integer.valueOf(this.syotekentta.getText());
        this.sovellus.miinus(syote);
        int vastaus = sovellus.tulos();
        String vastausString = String.valueOf(vastaus);
        this.tuloskentta.setText(vastausString);
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {

        this.sovellus.asetaArvo(this.arvoNyt);
        int vastaus = sovellus.tulos();
        String vastausString = String.valueOf(vastaus);
        this.tuloskentta.setText(vastausString);
        this.syotekentta.setText("");
    }
}
