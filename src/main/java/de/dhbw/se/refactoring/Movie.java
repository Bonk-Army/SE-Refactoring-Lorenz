package de.dhbw.se.refactoring;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;

    public Movie(String newtitle, int newpriceCode) {
        this.title = newtitle;
        this.priceCode = newpriceCode;
    }

    public int getPriceCode() {
        return this.priceCode;
    }

    public void setPriceCode(int arg) {
        this.priceCode = arg;
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
