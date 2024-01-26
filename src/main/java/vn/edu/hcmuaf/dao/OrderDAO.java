package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
    public static OrderDAO getInstance() {
        return new OrderDAO();
    }

    public int getMaxId() throws SQLException {
        String sql = "select max(id) from orders";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        int res = 0;
        while (rs.next()) {
            res = rs.getInt(1);
        }
        return res;
    }

    public void insertOrder(UserDAO userDAO,String username,int total_price) throws SQLException {
        String sql = "insert into orders (id,user_id,created_at,total_price) values (?,?,CURRENT_TIMESTAMP,?)";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setInt(1, getMaxId() + 1);
        pr.setInt(2, userDAO.getUserid(username));
        pr.setInt(3, total_price);
        pr.executeUpdate();
        pr.close();
        MySqlConnection.getConnection().close();
    }

    public ResultSet getOrder() throws SQLException {
        String sql = "select orders.id,orders.user_id,orders.created_at,orders.total_price,users.id,users.username from orders inner join users on orders.user_id=users.id";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        return rs;
    }

    public static void main(String[] args) throws SQLException {
        OrderDAO orderDAO = OrderDAO.getInstance();
        System.out.println(orderDAO.getOrder());

    }
}
