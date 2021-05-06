package de.dhbw.se.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    final String CUSTOMERNAME = "LORENZ";
    final String MOVIETITEL = "Harry Potter";
    final int PRICECODE = 1;
    final int RENTINGDAYS = 14;

    final String RESULSTRING = "de.dhbw.se.refactoring.Rental Record for " + this.CUSTOMERNAME + "\n" + "\tTitle\t\tDays\tAmount\n" + "\t" + this.MOVIETITEL
            + "\t\t" + this.RENTINGDAYS + "\t42.0\n" + "Amount owed is 42.0\n" + "You earned 2 frequent renter points";

    Movie testMovie;
    Rental testRental;
    Customer testCustomer;

    @BeforeEach
    public void setUp() {
        this.testMovie = new Movie(this.MOVIETITEL, this.PRICECODE);
        this.testRental = new Rental(this.testMovie, this.RENTINGDAYS);
        this.testCustomer = new Customer(this.CUSTOMERNAME);
    }

    @Test
    public void addRental() {
        this.testCustomer.addRental(this.testRental);
    }

    @Test
    public void getName() {
        assertEquals(this.CUSTOMERNAME, this.testCustomer.getName());
    }

    @Test
    public void statement() {
        this.testCustomer.addRental(this.testRental);
        assertEquals(this.RESULSTRING, this.testCustomer.statement());
    }
}
