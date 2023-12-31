package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.User;

import java.sql.SQLException;

public class LoginService {
    public User getUser(String username, String pass) throws SQLException {
       User user= UserDAO.getInstance().selectInformation(username, pass);
        return user;
    }

}
