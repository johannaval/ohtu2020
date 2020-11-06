package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjanpito_rajapinta {

    void lisaaTapahtuma(String tapahtuma);

    ArrayList<String> getTapahtumat();
}
