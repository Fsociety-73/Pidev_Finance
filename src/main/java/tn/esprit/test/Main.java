package tn.esprit.test;

import tn.esprit.models.User;
import tn.esprit.services.AdminService;
import tn.esprit.models.Admin;
import tn.esprit.models.Client;
import tn.esprit.services.ClientService;
import tn.esprit.utils.MyDataBase;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Create a SimpleDateFormat instance to parse date strings
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Parse date strings to Date objects
        Date dateOfBirth1 = sdf.parse("1990-01-01");
        Date dateOfBirth2 = sdf.parse("1985-05-15");

        // Get the database connection
        Connection cnx = MyDataBase.getInstance().getCnx();

        // Create test users
        Admin admin1 = new Admin("20202020", "John", "Doe", "johndoe", "john@example.com", "password123", "123456789", dateOfBirth1, "New York", "12345");
        Client client1 = new Client("02020202", "Alice", "Smith", "alicesmith", "alice@example.com", "password456", "987654321", dateOfBirth2, "Los Angeles", "54321");

        // Create an instance of AdminService with the database connection
        AdminService adminService = new AdminService();

        // Create an instance of ClientService with the database connection
        ClientService clientService = new ClientService(cnx);

        // Test adding users
        adminService.add(admin1);
        clientService.add(client1);

        // Test getting all users
        System.out.println("All users:");
        System.out.println(adminService.getAll());

        // Test deleting a user (assuming delete method is implemented)
        clientService.delete(client1);

        // Update a user
        admin1.setCity("Chicago");
        adminService.update(admin1);

        // Print all users after delete and update operations
        System.out.println("All users after delete and update:");
        System.out.println(adminService.getAll());

        // Find user by email
        String emailToFind = "john@example.com";
        User foundUser = adminService.findByEmail(emailToFind);
        System.out.println("User found by email: " + foundUser);

    }
}
