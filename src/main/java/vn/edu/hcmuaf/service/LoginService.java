package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginService {
    public ArrayList<User> getAllUser() throws SQLException {
        ArrayList<User> listuser= UserDAO.getInstance().getUsernameandPassword();
        return listuser;
    }
    public String getEmail(String username) throws SQLException {
        String email= UserDAO.getInstance().getEmailforLogin(username);
        return email;
    }

}