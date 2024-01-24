package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.model.Order;

import java.sql.SQLException;
import java.util.List;

//get ordered details
public class OrderManageService {
    public List<Order> getListOrderDetails() throws SQLException {
        OrderDAO orderDAO= OrderDAO.getInstance();
        return orderDAO.getOrderDetails();
    }
}
