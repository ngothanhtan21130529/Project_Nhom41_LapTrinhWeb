package DAO;

import connection.MySqlConnection;
import model.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDAO implements DAOInterface<Category> {
    public static CategoryDAO getInstance() {
        return new CategoryDAO();
    }

    @Override
    public int insert(Category category){
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "insert into categories (id, category_name, create_at, update_at, img_url)"+
                    "values(?,?,?,?,?)";
//            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getCategoryName());
            ps.setTimestamp(3, category.getCreatedAt());
            ps.setTimestamp(4, category.getUpdatedAt());
            ps.setString(5, category.getImgURL());
            res=ps.executeUpdate();

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int update(Category category) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "update categories set categories_name=?, create_at=?, update_at=?, img_url=?"+
                    "where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCategoryName());
            ps.setTimestamp(2, category.getCreatedAt());
            ps.setTimestamp(3, category.getUpdatedAt());
            ps.setString(4, category.getImgURL());
            res=ps.executeUpdate();

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int delete(Category category) {
        int res=0;
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "delete from categories where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            res=ps.executeUpdate();

            System.out.println("Execute querry success: "+sql);
            System.out.println("There "+res+" line changed!");

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public Category selectById(Category category) {
        Category res=null;
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "select * from categories where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            System.out.println(sql);
            ResultSet rs =ps.executeQuery();

            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("categories_name");
                Timestamp createdAt=rs.getTimestamp("create_at");
                Timestamp updatedAt=rs.getTimestamp("update_at");
                Timestamp deletedAt=rs.getTimestamp("delete_at");
                String imgURL = rs.getString("img_url");

                res = new Category(id, category.getCategoryName(), createdAt, updatedAt, deletedAt, imgURL);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public ArrayList<Category> selectByCondition(String condition) {
        ArrayList<Category> res=new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "select * from categories where "+condition+";";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println(sql);
            ResultSet rs =ps.executeQuery();

            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("categories_name");
                Timestamp createdAt=rs.getTimestamp("create_at");
                Timestamp updatedAt=rs.getTimestamp("update_at");
                Timestamp deletedAt=rs.getTimestamp("delete_at");
                String imgURL = rs.getString("img_url");

                Category category=new Category(id, name, createdAt, updatedAt, deletedAt, imgURL);
                res.add(category);
            }

            MySqlConnection.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public ArrayList<Category> getListCategory(){
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT categories.id, categories.category_name, images.img_url " +
                    "FROM categories " +
                    "JOIN images ON categories.id = images.category_id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String categoryName = rs.getString("category_name");
                String imgURL = rs.getString("img_url");

                Category category = new Category(id, categoryName, imgURL);
                categories.add(category);
            }
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

}
