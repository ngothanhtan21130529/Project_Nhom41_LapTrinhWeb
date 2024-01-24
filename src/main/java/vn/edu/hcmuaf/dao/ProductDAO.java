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

    public int count(String txtSearch) {
        try {
            String querry = "select count(products.id) from products where products.product_name like ?";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Product> search(String txtSearch, int index, int size) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            String querry = "with res as (select row_number() over (order by p.id asc) " +
                    "as r, i.img_url, p.product_name, p.price from products p " +
                    "join images i on p.thumbnail_id=i.id " +
                    "where p.product_name like ?) " +
                    "select * from res where r between (?*?)-(?-1) and (?*?)";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(querry);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, index);
            ps.setInt(3, size);
            ps.setInt(4, size);
            ps.setInt(5, index);
            ps.setInt(6, size);
            System.out.println(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                productList.add(product);
//                return productList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
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
    public  ArrayList<Product> getListProductFull(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select p.id, p.product_name, p.category_id, i.img_url, \n" +
                    "p.price, p.sale, p.hot, p.description, p.created_at, \n" +
                    "p.updated_at, p.deleted_at, p.color, p.weight, p.size, \n" +
                    "p.opacity, p.status, p.cutting_grinding_type, p.material\n" +
                    "from products p JOIN images i on p.thumbnail_id=i.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            /*
            * Product(int id, String productName, int categoryID, String imgURL,
                   int price, int sale, boolean hot, String description,
                   Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt,
                   String color, String weight, String size, String opacity,
                   String status, String cuttingGrindingShape, String marterial
            * */
            while (rs.next()) {
                Product product=new Product(
                        rs.getInt("id"),
                        rs.getString("product_name"),
                        rs.getInt("category_id"),
                        rs.getString("img_url"),
                        rs.getInt("price"),
                        rs.getInt("sale"),
                        rs.getBoolean("hot"),
                        rs.getString("description"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getTimestamp("deleted_at"),
                        rs.getString("color"),
                        rs.getString("weight"),
                        rs.getString("size"),
                        rs.getString("opacity"),
                        rs.getString("status"),
                        rs.getString("cutting_grinding_type"),
                        rs.getString("material")
                );
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
