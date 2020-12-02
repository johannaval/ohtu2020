package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    public Matcher[] list;

    public Or(Matcher... matchers) {
        this.list = matchers;
    }

    @Override
    public boolean matches(Player player) {
        for (Matcher matcher : this.list) {
            if (matcher.matches(player)) {
                return true;
            }
        }
        return false;
    }
}

