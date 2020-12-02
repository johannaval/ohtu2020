package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {

        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "assists")
                .hasFewerThan(5, "goals").pino();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(40, "points").pino();

        Matcher m = query.oneOf(m1, m2).pino();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }

}


