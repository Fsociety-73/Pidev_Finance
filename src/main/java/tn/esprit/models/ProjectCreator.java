package tn.esprit.models;

import java.util.Date;

public class ProjectCreator extends User {

    // Constructor


    public ProjectCreator(String cin, String firstName, String lastName, String username, String email, String password, String phone, Date dateOfBirth, String city, String zip) {
        super(cin, firstName, lastName, username, email, password, phone, dateOfBirth, city, zip, "project_creator");
    }

    // Add any specific methods or properties for the ProjectCreator class here
}
