package dk.nikolaj.webbank.model;

import java.util.Objects;

public class Currency {

    private final String from;
    private final String to;

    public Currency(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Currency currency = (Currency) object;
        return Objects.equals(from, currency.from) && Objects.equals(to, currency.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
