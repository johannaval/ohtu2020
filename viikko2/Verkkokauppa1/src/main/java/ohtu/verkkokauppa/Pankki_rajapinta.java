package ohtu.verkkokauppa;

public interface Pankki_rajapinta {

    boolean tilisiirto(String nimi, int viitenumero, String tililta,
                       String tilille, int summa);
}
