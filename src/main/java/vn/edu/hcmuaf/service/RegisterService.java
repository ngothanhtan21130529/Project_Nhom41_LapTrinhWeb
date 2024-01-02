package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.User;

import java.sql.SQLException;

public class RegisterService {
    public boolean insertUser(User user) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        if (userDAO.insertUser(user)) {
            return true;
        } else {
            return false;
        }

    }
    public int getMaxID() throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        int maxID = userDAO.getMaxID();
        return maxID;
    }
}
