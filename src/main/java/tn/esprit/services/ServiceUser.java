package tn.esprit.services;

import tn.esprit.interfaces.IService;
import tn.esprit.models.User;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;

public class ServiceUser<T> implements IService<T> {
    private Connection cnx;

    public ServiceUser(String admin) {
        cnx = MyDataBase.getInstance().getCnx();
    }

    public ServiceUser() {

    }

    @Override
    public void add(T t) {
        if (!(t instanceof User)) {
            throw new IllegalArgumentException("Unsupported type");
        }
        User user = (User) t;
        String qry = "INSERT INTO `users` (`carte_cin`, `first_name`, `last_name`, `username`, `email`, `password`, `phone`, `date_of_birth`, `city`, `zip`, `role`, `created_at`, `last_modified_at`, `last_active_at`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = cnx.prepareStatement(qry);
            stm.setString(1, user.getCin());
            stm.setString(2, user.getFirstName());
            stm.setString(3, user.getLastName());
            stm.setString(4, user.getUsername());
            stm.setString(5, user.getEmail());
            stm.setString(6, user.getPassword());
            stm.setString(7, user.getPhone());
            stm.setDate(8, new java.sql.Date(user.getDateOfBirth().getTime()));
            stm.setString(9, user.getCity());
            stm.setString(10, user.getZip());
            stm.setString(11, user.getRole());
            stm.setTimestamp(12, new Timestamp(user.getCreatedAt().getTime()));
            stm.setTimestamp(13, new Timestamp(user.getLastModifiedAt().getTime()));
            stm.setTimestamp(14, new Timestamp(user.getLastActiveAt().getTime()));

            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<T> getAll() {
        ArrayList<T> users = new ArrayList<>();
        String qry = "SELECT * FROM `users`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setCin(rs.getString("carte_cin"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
                user.setCity(rs.getString("city"));
                user.setZip(rs.getString("zip"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setLastModifiedAt(rs.getTimestamp("last_modified_at"));
                user.setLastActiveAt(rs.getTimestamp("last_active_at"));

                users.add((T) user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


    @Override
    public boolean update(T t) {
        if (!(t instanceof User)) {
            throw new IllegalArgumentException("Unsupported type");
        }
        User user = (User) t;
        String sql = "UPDATE users SET first_name = ?, last_name = ?, username = ?, email = ?, password = ?, phone = ?, date_of_birth = ?, city = ?, zip = ?, role = ?, last_modified_at = ? WHERE carte_cin = ?";
        try (PreparedStatement statement = cnx.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getPhone());
            statement.setDate(7, new java.sql.Date(user.getDateOfBirth().getTime()));
            statement.setString(8, user.getCity());
            statement.setString(9, user.getZip());
            statement.setString(10, user.getRole());
            statement.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
            statement.setString(12, user.getCin()); // Set carte_cin as the identifier

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // Return true if at least one row was updated
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false; // Return false if an exception occurred
        }
    }

    @Override
    public boolean delete(T t) {
        if (!(t instanceof User)) {
            throw new IllegalArgumentException("Unsupported type");
        }
        User user = (User) t;
        String sql = "DELETE FROM users WHERE email = ?";
        try (PreparedStatement statement = cnx.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
            return false;
        }
    }


}
