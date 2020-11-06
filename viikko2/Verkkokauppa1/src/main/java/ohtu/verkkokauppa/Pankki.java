package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Pankki implements Pankki_rajapinta {

    private Kirjanpito kirjanpito;

    public Pankki(Kirjanpito kirjanpito) {

        this.kirjanpito = this.kirjanpito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
