package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.models.User;


import tn.esprit.services.ServiceUser;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    private ServiceUser userService = new ServiceUser(); // Assuming you have a ServiceUser implementation

    @FXML
    public void Loginclicked() {
        String enteredEmail = email.getText();
        String enteredPassword = password.getText();

        // Perform authentication logic (this will involve database interaction)
        User authenticatedUser = authenticateUser(enteredEmail, enteredPassword);

        if (authenticatedUser != null) {
            // Login successful!
            try {
                redirectBasedOnRole(authenticatedUser.getRole());
            } catch (IOException e) {
                System.err.println("Error redirecting: " + e.getMessage());
            }
        } else {
            // Login failed
            System.out.println("Invalid email or password.");
            // Display an error message here
        }
    }

    private User authenticateUser(String enteredEmail, String enteredPassword) {
        // Replace with the actual implementation to query the database
        // ... your database authentication logic here ...

        // For placeholder: Simulate successful login with hardcoded values
        if (enteredEmail.equals("admin@email.com") && enteredPassword.equals("password")) {
            return new User("123456", "Admin", "User", "", enteredEmail, enteredPassword, "...", null, "", "", "admin");
        } else {
            return null; // Login failed
        }
    }

    private void redirectBasedOnRole(String role) throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow(); // Get the current stage
        stage.close(); // Close the login window

        switch (role) {
            case "admin":
                loadFXML("AdminDashboard.fxml");
                break;
            case "user":
                loadFXML("UserDashboard.fxml");
                break;
            // ... add cases for other roles ...
            default:
                loadFXML("DefaultDashboard.fxml");
        }
    }

    private void loadFXML(String fxmlName) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlName));
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.show();
    }
}