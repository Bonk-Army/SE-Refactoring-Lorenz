package de.dhbw.se.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private final String CUSTOMERNAME = "LORENZ";
    private final String MOVIETITEL = "Harry Potter";
    private final int PRICECODE = 1;
    private final int RENTINGDAYS = 14;
    private final int RENTINGPOINTS = 2;

    private final String RESULTSTRING = "de.dhbw.se.refactoring.Rental Record for " + this.CUSTOMERNAME + "\n" + "\tTitle\t\tDays\tAmount\n" + "\t"
            + this.MOVIETITEL + "\t\t" + this.RENTINGDAYS + "\t42.0\n" + "Amount owed is 42.0\n" + "You earned 2 frequent renter points";

    private final String RESULTSTRINGHTML = "<H1>Rentals for <EM>" + this.CUSTOMERNAME + "</EM></H1><P>\n" + "" + this.MOVIETITEL + ": 42.0<BR>\n"
            + "<P>You owe <EM>42.0</EM><P>\n" + "On this rental you earned <EM>" + this.RENTINGPOINTS + "</EM> frequent renter points<P>";

    private Movie testMovie;
    private Rental testRental;
    private Customer testCustomer;

    @BeforeEach
    public void setUp() {
        this.testMovie = new Movie(this.MOVIETITEL, this.PRICECODE);
        this.testRental = new Rental(this.testMovie, this.RENTINGDAYS);
        this.testCustomer = new Customer(this.CUSTOMERNAME);
    }

    @Test
    public void addRental() {
        try {
            this.testCustomer.addRental(this.testRental);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getName() {
        assertEquals(this.CUSTOMERNAME, this.testCustomer.getName());
    }

    @Test
    public void statement() {
        this.testCustomer.addRental(this.testRental);
        assertEquals(this.RESULTSTRING, this.testCustomer.statement());
    }

    @Test
    public void statementHtml() {
        this.testCustomer.addRental(this.testRental);
        assertEquals(this.RESULTSTRINGHTML, this.testCustomer.htmlStatement());
    }
}
