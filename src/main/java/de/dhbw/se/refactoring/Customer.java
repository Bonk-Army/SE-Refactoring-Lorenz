package de.dhbw.se.refactoring;

import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;

    private Vector rentals = new Vector();

    public Customer(String newname) {
        this.name = newname;
    }

    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String responseString = "de.dhbw.se.refactoring.Rental Record for " + this.getName() + "\n";
        responseString += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            frequentRenterPoints += rental.getFrequentRenterPoints();

            //show figures for this rental
            responseString += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getCharge() + "\n";
            totalAmount += rental.getCharge();
        }
        //add footer lines
        responseString += "Amount owed is " + totalAmount + "\n";
        responseString += "You earned " + frequentRenterPoints + " frequent renter points";
        return responseString;
    }

}
