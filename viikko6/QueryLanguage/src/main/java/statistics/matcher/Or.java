package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    public Matcher[] list;

    public Or(Matcher... matcher) {
        this.list = matcher;
    }

    @Override
    public boolean matches(Player player) {
        for (Matcher matcher : list) {
            if (matcher.matches(player)) {
                return true;
            }
        }
        return false;
    }
}

