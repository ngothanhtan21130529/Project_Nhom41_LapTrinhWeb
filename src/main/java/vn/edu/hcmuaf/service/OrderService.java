package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;

import java.sql.SQLException;

//insert data  fall down  to DAO layer
public class OrderService {
    OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO=new OrderDAO();
    }
    public String getEmailforOrder(String username) throws SQLException {
        return UserDAO.getInstance().getEmailforOrder(username);
    }


    public int getMaxId() throws SQLException {
        return  OrderDAO.getInstance().getMaxId();
    }
    public void insertOrder(UserDAO userDAO,String username,int total_price) throws SQLException {
        OrderDAO.getInstance().insertOrder(userDAO,username,total_price);
    }
    //    public boolean insertOrder(String username,String email,String address,String phone,String note,String total,String status) throws SQLException {
//        return UserDAO.getInstance().insertOrder(username,email,address,phone,note,total,status);
//    }
    public void update(Order order){
        orderDAO.update(order);
    }
}
