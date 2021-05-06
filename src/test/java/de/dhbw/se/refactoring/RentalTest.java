package de.dhbw.se.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RentalTest {

    private final String MOVIETITEL = "Harry Potter";
    private final int PRICECODE = 1;
    private final int RENTINGDAYS = 14;

    private Movie testMovie;
    private Rental testRental;

    @BeforeEach
    public void setUp() {
        this.testMovie = new Movie(this.MOVIETITEL, this.PRICECODE);
        this.testRental = new Rental(this.testMovie, this.RENTINGDAYS);
    }

    @Test
    public void getDaysRented() {
        assertEquals(this.RENTINGDAYS, this.testRental.getDaysRented());
    }

    @Test
    public void getMovie() {
        assertEquals(this.testMovie, this.testRental.getMovie());
    }
}
