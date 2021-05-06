package de.dhbw.se.refactoring;

import de.dhbw.se.refactoring.prices.ChildrensPrice;
import de.dhbw.se.refactoring.prices.NewReleasePrice;
import de.dhbw.se.refactoring.prices.Price;
import de.dhbw.se.refactoring.prices.RegularPrice;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private Price price;

    public Movie(String newtitle, int newpriceCode) {
        this.title = newtitle;
        this.setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return this.price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                this.price = new RegularPrice();
                break;
            case CHILDRENS:
                this.price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                this.price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return this.title;
    }

    public double getCharge(int daysRented) {
        return this.price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.price.getFrequentRenterPoints(daysRented);
    }
}
