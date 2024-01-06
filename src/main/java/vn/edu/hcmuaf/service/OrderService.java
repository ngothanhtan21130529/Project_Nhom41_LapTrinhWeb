package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

//insert data  fall down  to DAO layer
public class OrderService {
    public String getEmailforOrder(String email,String username) throws SQLException, SQLException {
        return UserDAO.getInstance().getEmailforOrder(email,username);
    }
//    public boolean insertOrder(String username,String email,String address,String phone,String note,String total,String status) throws SQLException {
//        return UserDAO.getInstance().insertOrder(username,email,address,phone,note,total,status);
//    }
}
