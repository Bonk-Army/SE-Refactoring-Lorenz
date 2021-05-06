package de.dhbw.se.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {

    private final String MOVIETITEL = "Harry Potter";
    private final int PRICECODE = 1;

    private Movie testMovie;

    @BeforeEach
    public void setUp() {
        this.testMovie = new Movie(this.MOVIETITEL, this.PRICECODE);
    }

    @Test
    public void getPriceCode() {
        assertEquals(this.PRICECODE, this.testMovie.getPriceCode());
    }

    @Test
    public void setPriceCode() {
        int newPricecode = 2;
        this.testMovie.setPriceCode(newPricecode);
        assertEquals(newPricecode, this.testMovie.getPriceCode());
    }

    @Test
    public void getTitle() {
        assertEquals(this.MOVIETITEL, this.testMovie.getTitle());
    }
}
