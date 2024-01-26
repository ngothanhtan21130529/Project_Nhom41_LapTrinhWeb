package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.dao.UserDAO;

import java.sql.SQLException;

//insert data  fall down  to DAO layer
public class OrderService {
    public String getEmailforOrder(String username) throws SQLException {
        return UserDAO.getInstance().getEmailforOrder( username);
    }


    public int getMaxId() throws SQLException {
       return  OrderDAO.getInstance().getMaxId();
    }
}
