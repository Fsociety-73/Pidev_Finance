package tn.esprit.models;
import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String cin;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Date dateOfBirth;
    private String city;
    private String zip;
    private String role;
    private Date createdAt;
    private Date lastModifiedAt;
    private Date lastActiveAt;

    // Constructor
    public User(String usernameValue, String firstnameValue, String lastnameValue, String emailValue, String cinValue, String passwordValue, LocalDate birthDate, String phoneValue, String zipValue, String cityValue, String roleValue) {
    }
    public User(String cin,String firstName, String lastName, String username, String email, String password, String phone, Date dateOfBirth, String city, String zip, String role) {
       this.cin =cin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.zip = zip;
        this.role = role;
        this.createdAt = new Date();
        this.lastModifiedAt = new Date();
        this.lastActiveAt = new Date();
    }

    public User() {

    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public Date getLastActiveAt() {
        return lastActiveAt;
    }

    public void setLastActiveAt(Date lastActiveAt) {
        this.lastActiveAt = lastActiveAt;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "carte_cin=" + cin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                ", lastActiveAt=" + lastActiveAt +
                "}\n";
    }


}

