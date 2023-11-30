package DAO;

import connection.MySqlConnection;
import model.Category;
import model.Image;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance(){
        return new ProductDAO();
    }
    @Override
    public int insert(Product product) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "insert into products (id, categories_id, img_id, name, available, price, status, create_at, update_at"+
                    "value('"+product.getId()+"', '"+product.getCategoryID()+"', '"+product.getThumbnail()+"', '"
                    +product.getProductName()+"', '"+product.getPrice()+"', '"+product.getStatus()+"')''";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int update(Product product) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "update products"+
                    "set"+
                    " category_id='"+product.getCategoryID()+"'"+
                    ", thumbnail='"+product.getThumbnail()+"'"+
                    ", name='"+product.getProductName()+"'"+
                    ", price='"+product.getPrice()+"'"+
                    ", status='"+product.getStatus()+"'"+
                    " where id='"+product.getId()+"\'";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int delete(Product product) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "delete from products"+
                    " where id='"+product.getId()+"'";
            res=st.executeUpdate(sql);

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public Product selectById(Product product) {
        Product res=null;
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from products where id='"+product.getId()+"'";
            System.out.println(sql);
            ResultSet rs =st.executeQuery(sql);

            while (rs.next()){
                int id=rs.getInt("id");
                int categoryId=rs.getInt("category_id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                String status=rs.getString("status");
                String imageURL=rs.getString("thumbnail");

                res=new Product(id, categoryId, name, price, status, imageURL);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public ArrayList<Product> selectByCondition(String condition) {
        ArrayList<Product> res=new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            Statement st = con.createStatement();
            String sql = "select * from products where"+condition;
            System.out.println(sql);
            ResultSet rs =st.executeQuery(sql);

            while (rs.next()){
                int id=rs.getInt("id");
                int categoryId=rs.getInt("category_id");
                String name=rs.getString("name");
                int price=rs.getInt("price");
                String status=rs.getString("status");
                String imageURL=rs.getString("thumbnail");

                Product product=new Product(id, categoryId, name, price, status, imageURL);
                res.add(product);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
    public int count(String txtSearch){
        try {
            String querry="select count(products.id) from products where products.name like ?";
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
}
