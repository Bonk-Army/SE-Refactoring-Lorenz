package de.dhbw.se.refactoring.Prices;

import de.dhbw.se.refactoring.Movie;

public class ChildrensPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
