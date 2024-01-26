package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;
import java.text.ParseException;

public class UpdateProfileService {
    public boolean updatePhone(String username, String phone) throws SQLException {
        UserDAO userDAO=UserDAO.getInstance();
        if(userDAO.UpdatePhone(username,phone)){
            return true;
        }else{
            return false;
        }
    }
    public boolean updateBirthday(String username, String birthday) throws SQLException, ParseException {
        UserDAO userDAO=UserDAO.getInstance();
        if(userDAO.UpdateBirthday(username,birthday)){
            return true;
        }else{
            return false;
        }
    }
}
