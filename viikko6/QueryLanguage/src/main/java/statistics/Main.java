package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        Matcher m = new And(
                new Not( new HasFewerThan(1, "goals") ),
                new PlaysIn("NYR")
        );


        System.out.println("kaikki:");
        System.out.println(stats.matches(new All()).size());

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
