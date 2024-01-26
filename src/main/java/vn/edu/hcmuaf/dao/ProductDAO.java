package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance() {
        return new ProductDAO();
    }

    @Override
    public int insert(Product product){
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

    public static ArrayList<Product> getListProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT p.id, p.product_name, p.price, p.status, i.img_url, inv.quantity " +
                    "FROM products p " +
                    "JOIN images i ON p.thumbnail_id = i.id " +
                    "LEFT JOIN inventories inv ON p.id = inv.product_id";
            try (
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String productName = rs.getString("product_name");
                    int price = rs.getInt("price");
                    String imgURL = rs.getString("img_url");
                    Integer quantity = (Integer) rs.getObject("quantity");

                    String status;
                    if (quantity == null) {
                        status = "Ngừng bán";
                    } else {
                        status = (quantity >= 1) ? "Đặt hàng" : "Hết hàng";
                    }

                    Product product = new Product(id, productName, price, status, imgURL);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product getProductByID(int productId) {
        Product product = null;
        try {
            String query = "SELECT p.id, p.product_name, p.price, p.status, p.description, i.img_url, inv.quantity " +
                    "FROM products p " +
                    "JOIN images i ON p.thumbnail_id = i.id " +
                    "JOIN inventories inv ON p.id = inv.product_id " +
                    "WHERE p.id = ?";
            Connection con = MySqlConnection.getConnection();
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, productId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String productName = rs.getString("product_name");
                        int price = rs.getInt("price");
                        String status = rs.getString("status");
                        String description = rs.getString("description");
                        String imgURL = rs.getString("img_url");
                        Integer quantity = (Integer) rs.getObject("quantity");

                        if (quantity == null) {
                            status = "Ngừng bán";
                        } else {
                            status = (quantity >= 1) ? "Đặt hàng" : "Hết hàng";
                        }

                        product = new Product(id, productName, price, status, description, imgURL);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }


    public void getListProducts() throws SQLException {
        String sql = "select products.product_name from products join order_details on products.id=order_details.product_id";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("products.product_name"));
        }
    }

    public int findIdProduct(String productname) throws SQLException {
        String sql = "select id from  products  where products.product_name=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, productname);
        ResultSet rs = pr.executeQuery();

        int id = 0;
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
    }

    public String getThumbnail(String productname) throws SQLException {
        String sql = "select img_url from images join products on images.id=products.thumbnail_id where products.product_name=?";
        PreparedStatement pr = MySqlConnection.getConnection().prepareStatement(sql);
        pr.setString(1, productname);
        ResultSet rs = pr.executeQuery();
        String img = "";
        while (rs.next()) {
            img = rs.getString("img_url");
        }
        return img;
    }

    public static void main(String[] args) throws SQLException {
        ProductDAO productDAO = new ProductDAO();
        System.out.println(productDAO.getThumbnail("VIÊN SPINEL HỒNG DÂU LỤC YÊN 3,56CT"));

    }
}
