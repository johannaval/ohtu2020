package ohtu.verkkokauppa;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viitegeneraattori;
    Varasto varasto;
    Kauppa kauppa;

    @Before
    public void setUp() {

        pankki = mock(Pankki.class);
        viitegeneraattori = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);

        when(viitegeneraattori.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.saldo(2)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "mansikkahillo", 3));
        kauppa = new Kauppa(varasto, pankki, viitegeneraattori);
    }


    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }

    @Test
    public void ostoksenTekoOnnistuuOikeillaParametreilla() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void kahdenEriOstoksenTekoOnnistuuOikeillaParametreilla() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(8));
    }

    @Test
    public void kahdenSamanOstoksenTekoOnnistuuOikeillaParametreilla() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));
    }

    @Test
    public void jaljellaOlevanJaLoppuneenTuotteenOstaminenOttaaVainJaljellaOlevanTuotteenHinnan() {

        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "lakkahillo", 6));

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
    }

    @Test
    public void edellisenAsioinninHintaEiNayUudenAsioinninHinnassa() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));

    }

    @Test
    public void uusiViitenumeroVaaditaanJokaiselleMaksutapahtumalle() {

        when(viitegeneraattori.uusi()).thenReturn(42);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));

        when(viitegeneraattori.uusi()).thenReturn(43);

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("pekanvaimo", "12346");
        verify(pankki).tilisiirto(eq("pekanvaimo"), eq(43), eq("12346"), eq("33333-44455"), eq(3));
    }

    @Test
    public void tuotteenPoistaminenKoristaToimii() {

        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(0));
    }
}
