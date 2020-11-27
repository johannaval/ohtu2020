package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {

    public Matcher negation;

    public Not(Matcher negation) {
        this.negation = negation;
    }

    @Override
    public boolean matches(Player player) {

        if (this.negation.matches(player)==false) {
            return true;
        }
        return false;
    }
}