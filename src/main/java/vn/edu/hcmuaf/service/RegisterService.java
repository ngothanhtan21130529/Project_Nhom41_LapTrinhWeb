package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.User;

import java.sql.SQLException;
import java.util.List;

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

    public boolean checkDuplicatedEmail(String email) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        List<String> emails = userDAO.checkedExistsEmail();
        for (String e : emails) {
            if (e.equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatedUsername(String username) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        List<String> usernames = userDAO.checkedExistsUsername();
        for (String u : usernames) {
            if (u.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String getEmailforAuth(String username) throws SQLException {
        UserDAO userDAO = UserDAO.getInstance();
        String email = userDAO.getEmailforRegister(username);
        return email;
    }

    public static void main(String[] args) {
        RegisterService registerService = new RegisterService();
        try {
            System.out.println(registerService.getEmailforAuth("tantt121"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}