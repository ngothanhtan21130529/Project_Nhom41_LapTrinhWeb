package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.dao.OrderDetailDAO;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//get ordered details
public class OrderManageService {
    public ResultSet getListOrders(OrderDAO orderDAO) throws SQLException {
        return OrderDetailDAO.getInstance().getListOrderDetails(orderDAO);
    }
}