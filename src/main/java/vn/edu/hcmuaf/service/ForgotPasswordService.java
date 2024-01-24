package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

public class ForgotPasswordService {
    public String getEmail(String email) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        String emailres = userDAO.getEmailForForgotPassword(email);
        return emailres;
    }

    public boolean updatePassword(String newpassword, String email) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        if (userDAO.updatePasswordforForgot(newpassword,email)) {
            return true;
        } else {
            return false;
        }

    }
}
