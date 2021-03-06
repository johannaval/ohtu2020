package statistics.matcher;

import statistics.Player;

public class And implements Matcher {

    public Matcher[] list;

    public And(Matcher... matchers) {
        this.list = matchers;
    }

    @Override
    public boolean matches(Player player) {
        for (Matcher matcher : list) {
            if (matcher.matches(player)==false) {
                return false;
            }
        }
        return true;
    }
}
