package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

public class ChangePasswordService {
    public boolean updatePassword(String username,String newpass) throws SQLException {
        UserDAO userDAO=UserDAO.getInstance();

        if(userDAO.updatePassword(username,newpass)){
            return true;
        }else{
            return false;
        }
    }
}