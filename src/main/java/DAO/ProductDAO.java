package DAO;

import connection.MySqlConnection;
import model.Product;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance(){
        return new ProductDAO();
    }

    @Override
    public int insert(Product product) throws SQLException {
        return 0;
    }

    @Override
    public int update(Product product) {
        return 0;
    }

    @Override
    public int delete(Product product) {
        return 0;
    }

    @Override
    public Product selectById(Product product) {
        return null;
    }

    @Override
    public ArrayList<Product> selectByCondition(String condition) {
        return null;
    }

    public static ArrayList<Product> getListProduct(){
        ArrayList<Product> products = new ArrayList<>();
        try{
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT p.id, p.product_name, p.price, p.status, i.img_url " +
                    "FROM products p " +
                    "JOIN images i ON p.thumbnail_id = i.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql );
            while (rs.next()){
                int id = rs.getInt("id");
                String productName = rs.getString("product_name");
                int price = rs.getInt("price");
                String status = rs.getString("status");
                String imgURL = rs.getString("img_url");

                Product product = new Product(id, productName, price, status, imgURL);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
