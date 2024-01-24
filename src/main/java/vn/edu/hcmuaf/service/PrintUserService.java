package vn.edu.hcmuaf.service;


import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.User;

import java.util.ArrayList;

public class PrintUserService {
    private UserDAO userDAO = new UserDAO();

    public PrintUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public PrintUserService() {
        userDAO = new UserDAO();
    }

    //lấy ra danh sách toàn bộ người dùng
    public ArrayList<User> getListUserFull() {
        return userDAO.getListUserFull();
    }
}
