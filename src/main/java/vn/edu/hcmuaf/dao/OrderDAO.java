package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public static OrderDAO getInstance() {
        return new OrderDAO();
    }
    public boolean insertOrder() {
        return true;
    }
    public List<Order> getOrderDetails() throws SQLException {
        List<Order> orderlist=new ArrayList<>();
        String sql="select * from order_details";
        PreparedStatement preparedStatement= MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Order order=new Order();
//            order.setOrderID(resultSet.getInt("order_id"));
//            order.setProductID(resultSet.getInt("product_id"));
//            order.setAmount(resultSet.getInt("amount"));
//            order.setPrice(resultSet.getInt("price"));
            orderlist.add(order);
        }
        return orderlist;
    }
}
