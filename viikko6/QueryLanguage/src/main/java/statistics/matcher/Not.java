package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {

    private Matcher list;

    public Not(Matcher matchers) {
        this.list = matchers;
    }

    @Override
    public boolean matches(Player player) {

        if (this.list.matches(player)==false) {
            return true;
        }
        return false;
    }
}