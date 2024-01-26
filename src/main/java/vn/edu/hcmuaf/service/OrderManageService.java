package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.dao.OrderDetailDAO;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//insert order details
public class OrderManageService {
public void insertOrderDetail(int productid, int orderid, int quantity_total, int total_price, String status,String address,String phone) throws SQLException{
    OrderDetailDAO.getInstance().insertOrderDetail(productid,orderid,quantity_total,total_price,status,address,phone);
}
}