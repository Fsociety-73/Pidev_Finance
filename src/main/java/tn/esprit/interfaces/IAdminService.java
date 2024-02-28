package tn.esprit.interfaces;

import tn.esprit.models.Admin;
import tn.esprit.models.User;

import java.util.ArrayList;

public interface IAdminService extends IService<Admin> {
    User findByEmail(String email);
    // Additional methods specific to admin service
    ArrayList<Admin> sortByName();

}

