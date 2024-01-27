package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DAOInterface<Order>{
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

    @Override
    public int insert(Order order) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "insert into orders (id, user_id , created_at, updated_at, total_price)" +
                    "values(?,?,CURRENT_TIMESTAMP,null,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getId());
            ps.setInt(2, order.getUserID());
            ps.setInt(3, order.getTotalPrice());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Order order) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "update orders o set " +
                    "o.updated_at=CURRENT_TIMESTAMP, o.status=? " +
                    "where o.id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, order.getStatus());
            ps.setInt(2, order.getId());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Order order) {
        return 0;
    }

    @Override
    public Order selectById(Order order) {
        return null;
    }

    @Override
    public ArrayList<Order> selectByCondition(String condition) {
        return null;
    }
    public ArrayList<Order> getListDistinctOrderFull() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String query = "select distinct o.id, u.full_name, u.phone, u.address, " +
                    "o.total_price, o.created_at, o.updated_at, o.status from " +
                    "orders o join users u on o.user_id=u.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt(1));
                order.setFullName(rs.getString(2));
                order.setPhone(rs.getString(3));
                order.setAddress(rs.getString(4));
                order.setTotalPrice(rs.getInt(5));
                order.setCreatedAt(rs.getTimestamp(6));
                order.setUpdatedAt(rs.getTimestamp(7));
                order.setStatus(rs.getString(8));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
