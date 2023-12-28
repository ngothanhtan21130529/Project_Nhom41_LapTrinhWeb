package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

public class ForgotPasswordService {
    public String getEmail(String email) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        String emailres = userDAO.getEmail(email);
        return emailres;
    }
}
