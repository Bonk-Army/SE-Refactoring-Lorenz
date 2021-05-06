package de.dhbw.se.refactoring.Prices;

import de.dhbw.se.refactoring.Movie;

public class NewReleasePrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
