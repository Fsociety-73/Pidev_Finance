package tn.esprit.models;

import java.util.Date;

public class Porteur extends User {

    // Constructor

    public Porteur(String cin, String firstName, String lastName, String username, String email, String password, String phone, Date dateOfBirth, String city, String zip) {
        super(cin, firstName, lastName, username, email, password, phone, dateOfBirth, city, zip, "porteur");
    }

    // Add any specific methods or properties for the Porteur class here
}
