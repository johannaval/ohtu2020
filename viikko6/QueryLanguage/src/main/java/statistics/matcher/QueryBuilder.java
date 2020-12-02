package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {

    Matcher pino;
    ArrayList<Matcher> list;

    public QueryBuilder() {
        this.pino = new All();
    }

    public Matcher pino() {
        Matcher newPino = this.pino;
        this.pino = new All();
        return newPino;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.pino = new And(new HasFewerThan(value, category), pino);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.pino = new And(new HasAtLeast(value, category), pino);
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.pino = new And(new PlaysIn(team), pino);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.pino = new Or(matchers);
        return this;
    }
}




