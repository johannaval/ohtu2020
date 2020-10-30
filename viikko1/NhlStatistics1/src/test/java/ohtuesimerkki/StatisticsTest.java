package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchLoytaaPelaajanJokaListalla(){

        Player pelaaja = stats.search("Gretzky");
        String etsittava = "Gretzky";

        assertEquals(etsittava, pelaaja.getName());

    }

    @Test
    public void searchEiLoydaPelaajaaJokaEiOleListalla(){

        Player pelaaja = stats.search("Gretzkyyyy");
        assertNull(pelaaja);
    }

    @Test
    public void teamPalauttaaOikeanKokoisenListanJoukkueenJasenista() {

        assertEquals(3, stats.team("EDM").size());

    }
    @Test
    public void topScorersPalauttaaListanOikein(){

        List <Player> pelaajat = new ArrayList<>();
        pelaajat = stats.topScorers(3);
        String nimi = pelaajat.get(3).getName();

        assertEquals("Kurri", nimi);
    }
    }
