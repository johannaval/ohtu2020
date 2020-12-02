package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {

    private Matcher[] list;

    public Not(Matcher... matchers) {
        this.list = matchers;
    }

    @Override
    public boolean matches(Player player) {

        for (Matcher matcher : list) {
            if (matcher.matches(player)) {
                return false;
            }
        }
        return true;
    }
}