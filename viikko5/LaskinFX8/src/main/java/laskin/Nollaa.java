package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {

    private int arvoNyt;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {

        this.arvoNyt = Integer.valueOf(this.tuloskentta.getText());
        this.sovellus.nollaa();
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
