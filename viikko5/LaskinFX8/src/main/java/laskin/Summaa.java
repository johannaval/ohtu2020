package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summaa extends Komento {
    public Summaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);

    }

    @Override
    public void suorita() {

        int syote = Integer.valueOf(this.syotekentta.getText());
        this.sovellus.plus(syote);
        int vastaus = sovellus.tulos();
        String vastausString = String.valueOf(vastaus);
        this.tuloskentta.setText(vastausString);
        this.syotekentta.setText("");
    }

    @Override
    public void peru() {

    }
}
