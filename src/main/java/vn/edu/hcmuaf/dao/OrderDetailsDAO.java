package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAO implements DAOInterface<OrderDetail> {
    @Override
    public int insert(OrderDetail orderDetail) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "insert into order_details (order_id, product_id, quantity_total, total_price, created_at, updated_at, status)" +
                    "values(?,?,?,?,CURRENT_TIMESTAMP,null,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderDetail.getOrderID());
            ps.setInt(2, orderDetail.getProductID());
            ps.setInt(3, orderDetail.getQuantityTotal());
            ps.setInt(4, orderDetail.getTotalPrice());
            ps.setString(5, orderDetail.getStatus());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int delete(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public OrderDetail selectById(OrderDetail orderDetail) {
        return null;
    }

    @Override
    public ArrayList<OrderDetail> selectByCondition(String condition) {
        return null;
    }
    public ArrayList<OrderDetail> getListOrderDetailFull() {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String query = "select od.id, od.order_id, p.product_name, p.price, od.quantity_total, " +
                    "(p.price*od.quantity_total) as \"Tổng tiền\" from order_details od " +
                    "join products p on od.product_id=p.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                orderDetails.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetails;
    }
    public ResultSet getProductFromOrderDetails() throws SQLException {
        String sql="select o.id, o.order_id, p.id, p.product_name, p.price, o.quantity_total, o.total_price_product from order_details o " +
                "join products p on o.product_id=p.id;";
        PreparedStatement ps=MySqlConnection.getConnection().prepareStatement(sql);
        return ps.executeQuery();
    }
}
