package de.dhbw.se.refactoring.Prices;

public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int getDaysRented);
}
