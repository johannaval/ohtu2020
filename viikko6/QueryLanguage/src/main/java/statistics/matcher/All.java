package statistics.matcher;

import statistics.Player;

public class All implements Matcher {

    private Matcher[] list;

    @Override
    public boolean matches(Player player) {
        return true;
    }
}
