package de.dhbw.se.refactoring;

import de.dhbw.se.refactoring.Prices.ChildrensPrice;
import de.dhbw.se.refactoring.Prices.NewReleasePrice;
import de.dhbw.se.refactoring.Prices.Price;
import de.dhbw.se.refactoring.Prices.RegularPrice;

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

    public double getCharge(int getDaysRented) {
        double result = 0;
        switch (this.getPriceCode()) {
            case REGULAR:
                result += 2;
                if (getDaysRented > 2) {
                    result += (getDaysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += getDaysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (getDaysRented > 3) {
                    result += (getDaysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((this.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
