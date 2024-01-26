package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

public class UserService {
    public int getUserId(String username) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        return userDAO.getUserid(username);

    }
}
