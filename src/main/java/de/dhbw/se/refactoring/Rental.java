package de.dhbw.se.refactoring;

class Rental {

    Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        this.movie = newmovie;
        this.daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public double getCharge() {
        return this.movie.getCharge(this.getDaysRented());
    }

    public int getFrequentRenterPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
