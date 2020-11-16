
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int taulukonKoko = 5;
    public final static int oletusKasvatus = 5;
    private int kasvatuskoko = 5;
    private int[] luvut;
    private int alkioidenLkm;

    public IntJoukko() {
        this.luvut = new int[taulukonKoko];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = oletusKasvatus;
    }

    public IntJoukko(int kapasiteetti) {
        this.luvut = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = oletusKasvatus;
    }

    public IntJoukko(int taulukonKoko, int kasvatuskoko) {

        if (taulukonKoko < 0) {
            System.out.println("Taulukon koko ei voi olla negatiivinen");

        } else if (kasvatuskoko < 0) {
            System.out.println("Taulukon kasvatuskoko ei voi olla negatiivinen");

        } else {
            luvut = new int[taulukonKoko];
            this.kasvatuskoko = kasvatuskoko;
        }
    }

    public boolean lisaa(int luku) {

        int[] alkuperainenTaulukko = new int[alkioidenLkm + oletusKasvatus];

        if (!kuuluu(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;

            if (alkioidenLkm == luvut.length) {
                kasvataTaulukkoa(alkuperainenTaulukko);
            }
            return true;
        }
        return false;
    }

    public void kasvataTaulukkoa(int[] alkuperainenTaulukko) {

        alkuperainenTaulukko = this.luvut;
        luvut = new int[alkioidenLkm + oletusKasvatus];
        kopioiTaulukko(alkuperainenTaulukko, luvut);
    }

    public boolean kuuluu(int luku) {

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luvut[i] == luku) {
                return true;
            }
        }
        return false;
    }


    public boolean poista(int luku) {

        int indeksi = -1;
        int arvoIndeksissa = -1;

        for (int i = 0; i < alkioidenLkm; i++) {
            if (luvut[i] == luku) {
                indeksi = i;
                for (int j = indeksi; j < alkioidenLkm - 1; j++) {
                    arvoIndeksissa = luvut[j];
                    luvut[j] = luvut[j + 1];
                    luvut[j + 1] = arvoIndeksissa;
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanhaTaulukko, int[] uusiTaulukko) {
        for (int i = 0; i < vanhaTaulukko.length; i++) {
            uusiTaulukko[i] = vanhaTaulukko[i];
        }
    }

    public int mahtavuus() {

        return alkioidenLkm;
    }


    @Override
    public String toString() {

        String listaaLuvut = "";

        if (alkioidenLkm > 0) {
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                listaaLuvut += luvut[i] + ", ";
            }
            listaaLuvut += luvut[alkioidenLkm - 1];
        }
        return "{" + listaaLuvut + "}";
    }

    public int[] toIntArray() {

        int[] taulukko = new int[alkioidenLkm];

        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = luvut[i];
        }
        return taulukko;
    }


    public static IntJoukko yhdiste(IntJoukko joukkoA, IntJoukko joukkoB) {

        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aJoukko = joukkoA.toIntArray();
        int[] bJoukko = joukkoB.toIntArray();

        for (int i = 0; i < aJoukko.length; i++) {
            yhdisteJoukko.lisaa(aJoukko[i]);
        }
        for (int i = 0; i < bJoukko.length; i++) {
            yhdisteJoukko.lisaa(bJoukko[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko joukkoA, IntJoukko joukkoB) {

        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aJoukko = joukkoA.toIntArray();
        int[] bJoukko = joukkoB.toIntArray();

        for (int i = 0; i < aJoukko.length; i++) {
            for (int j = 0; j < bJoukko.length; j++) {
                if (aJoukko[i] == bJoukko[j]) {
                    leikkausJoukko.lisaa(bJoukko[j]);
                }
            }
        }
        return leikkausJoukko;

    }

    public static IntJoukko erotus(IntJoukko joukkoA, IntJoukko joukkoB) {
        IntJoukko erotusJoukko = new IntJoukko();

        int[] aJoukko = joukkoA.toIntArray();
        int[] bJoukko = joukkoB.toIntArray();

        for (int i = 0; i < aJoukko.length; i++) {
            erotusJoukko.lisaa(aJoukko[i]);
        }
        for (int i = 0; i < bJoukko.length; i++) {
            erotusJoukko.poista(bJoukko[i]);
        }

        return erotusJoukko;
    }

}
