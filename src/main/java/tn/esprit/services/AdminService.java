package tn.esprit.services;

import tn.esprit.interfaces.IAdminService;
import tn.esprit.models.Admin;
import tn.esprit.models.User;
import tn.esprit.utils.MyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdminService extends ServiceUser<Admin> implements IAdminService {

    public AdminService() {
        super("admin");
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection cnx = MyDataBase.getInstance().getCnx();
             PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setCin(resultSet.getString("carte_cin"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setUsername(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setPhone(resultSet.getString("phone"));
        user.setDateOfBirth(resultSet.getDate("date_of_birth"));
        user.setCity(resultSet.getString("city"));
        user.setZip(resultSet.getString("zip"));
        user.setRole(resultSet.getString("role"));
        user.setCreatedAt(resultSet.getTimestamp("created_at"));
        user.setLastModifiedAt(resultSet.getTimestamp("last_modified_at"));
        user.setLastActiveAt(resultSet.getTimestamp("last_active_at"));
        return user;
    }

    public ArrayList<Admin> sortByName() {
        ArrayList<Admin> admins = getAll();

        // Define a custom comparator to sort by first name
        Comparator<Admin> firstNameComparator = new Comparator<Admin>() {
            @Override
            public int compare(Admin admin1, Admin admin2) {
                return admin1.getFirstName().compareTo(admin2.getFirstName());
            }
        };

        // Sort the admins using the custom comparator
        Collections.sort(admins, firstNameComparator);

        return admins;
    }
}
