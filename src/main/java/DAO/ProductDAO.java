package DAO;

import connection.MySqlConnection;
import model.Product;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public int count(String txtSearch){
        try {
            String querry="select count(products.id) from products where products.product_name like ?";
            Connection con=MySqlConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(querry);
            ps.setString(1,"%"+txtSearch+"%");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Product> search(String txtSearch, int index, int size){
        ArrayList<Product>productList=new ArrayList<>();
        try {
            String querry="with res as (select row_number() over (order by p.id asc) " +
                    "as r, i.img_url, p.product_name, p.price from products p " +
                    "join images i on p.thumbnail_id=i.id " +
                    "where p.product_name like ?) " +
                    "select * from res where r between (?*?)-(?-1) and (?*?)";
            Connection con=MySqlConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(querry);
            ps.setString(1,"%"+txtSearch+"%");
            ps.setInt(2,index);
            ps.setInt(3,size);
            ps.setInt(4,size);
            ps.setInt(5, index);
            ps.setInt(6, size);
            System.out.println(querry);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Product product=new Product(rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                productList.add(product);
//                return productList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
