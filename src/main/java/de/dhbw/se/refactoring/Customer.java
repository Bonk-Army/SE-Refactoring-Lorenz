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
        Enumeration rentals = this.rentals.elements();
        String responseString = "de.dhbw.se.refactoring.Rental Record for " + this.getName() + "\n";
        responseString += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();

            //show figures for this rental
            responseString += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getCharge() + "\n";
        }
        //add footer lines
        responseString += "Amount owed is " + this.getTotalCharge() + "\n";
        responseString += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
        return responseString;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM>" + this.getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental rental = (Rental) rentals.nextElement();
            //show figures for each rental          
            result += rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
        }
        //add footer lines      
        result += "<P>You owe <EM>" + String.valueOf(this.getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(this.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }
}
