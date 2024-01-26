package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDAO {
    public static OrderDetailDAO getInstance() {
        return new OrderDetailDAO();
    }

    public int getMaxid() throws SQLException {
        String sql = "select max(id) from order_details";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        int max = 0;
        while (rs.next()) {
            max = rs.getInt(1);
        }
        return max;
    }

    public void insertOrderDetail(int productid, int orderid, int quantity_total, int total_price, String status,String address,String phone) throws SQLException {
        String sql = "insert into order_details(id,product_id,order_id,quantity_total,total_price,status,address,phone) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
       pr.setInt(1, getMaxid() + 1);
        pr.setInt(2, productid);
        pr.setInt(3, orderid);
        pr.setInt(4, quantity_total);
        pr.setInt(5, total_price);
        pr.setString(6, status);
        pr.setString(7,address);
        pr.setString(8,phone);

        pr.executeUpdate();
    }

    public ResultSet getListOrderDetails(OrderDAO orderDAO) throws SQLException {
        String sql = "Select order_details.id,product_id,order_id,quantity_total,order_details.total_price,order_details.created_at,order_details.status from order_details join orders on order_details.order_id=orders.id";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet ordersRS = orderDAO.getOrder();
        ResultSet orderdetailsRS = pr.executeQuery();
        while (orderdetailsRS.next()) {
            while (ordersRS.next()) {
                if (ordersRS.getInt("orders.user_id") == ordersRS.getInt("users.id")) {
                    User user = new User(ordersRS.getInt("users.id"), ordersRS.getString("users.username"));
                    Order order = new Order(ordersRS.getInt("orders.id"), ordersRS.getInt("orders.user_id"), ordersRS.getTimestamp("orders.created_at"), ordersRS.getInt("orders.total_price"), user);
                    ProductDAO productDAO = ProductDAO.getInstance();
                    Product product = productDAO.getProductByID(orderdetailsRS.getInt("orders_detail.product_id"));
                    OrderDetail orderDetail = new OrderDetail(orderdetailsRS.getInt("orders_detail.id"), orderdetailsRS.getInt("orders_detail.product_id"), orderdetailsRS.getInt("orders_detail.order_id"), orderdetailsRS.getInt("orders_detail.quantity_total"), orderdetailsRS.getInt("orders_detail.total_price"), orderdetailsRS.getTimestamp("orders_detail.created_at"), orderdetailsRS.getString("orders_detail.status"), order, product);
                }
            }
        }
        return orderdetailsRS;
    }


    public static void main(String[] args) throws SQLException {
        OrderDetailDAO orderDetailDAO = OrderDetailDAO.getInstance();
        orderDetailDAO.getListOrderDetails(OrderDAO.getInstance());
//        orderDetailDAO.insertOrderDetail();
    }
}
