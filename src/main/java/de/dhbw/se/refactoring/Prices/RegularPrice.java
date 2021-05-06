package de.dhbw.se.refactoring.Prices;

import de.dhbw.se.refactoring.Movie;

public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
