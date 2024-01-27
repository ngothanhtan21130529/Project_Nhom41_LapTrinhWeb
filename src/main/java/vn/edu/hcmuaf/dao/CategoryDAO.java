package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.SearchService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAOInterface<Category> {
    public static CategoryDAO getInstance(){
        return new CategoryDAO();
    }
    @Override
    public int insert(Category c) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "insert into categories (id, category_name, created_at, updated_at, deleted_at, status, img_id)" +
                    "values(?,?,CURRENT_TIMESTAMP,null,null,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getCategoryName());
            ps.setString(3, c.getStatus());
            ps.setInt(4, c.getImgID());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Category c) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "update categories c set c.category_name=?, " +
                    "c.updated_at=CURRENT_TIMESTAMP, c.status=? " +
                    "where c.id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setString(2, c.getStatus());
            ps.setInt(3, c.getId());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int delete(Category c) {
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "delete from categories where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            int res = ps.executeUpdate();
            ps.close();
            con.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category selectById(Category category) {
        return null;
    }

    @Override
    public ArrayList selectByCondition(String condition) {
        return null;
    }

    public static ArrayList<Category> getListCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT c.id, c.category_name, i.img_url FROM categories c " +
                    "JOIN images i ON c.img_id = i.id";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("category_name");
                String imgURL = rs.getString("img_url");

                Category category = new Category(id, categoryName, imgURL);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public static ArrayList<Category> getNameCategory() {
        ArrayList<Category> categoriesName = new ArrayList<>();
        try {
            Connection con = MySqlConnection.getConnection();
            String sql = "SELECT c.id, c.category_name FROM categories c ";
            try (
                    PreparedStatement ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery(sql)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String categoryName = rs.getString("category_name");
                    Category category = new Category(id, categoryName);
                    categoriesName.add(category);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoriesName;
    }
    public int count() {
        try {
            String query = "select count(categories.id) from categories;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public ArrayList<Category> getListCategoryFull() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String query = "select c.id, c.category_name, i.img_url, c.created_at, c.updated_at, c.deleted_at, c.status, i.id from categories c join images i on c.img_id=i.id;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4),
                        rs.getTimestamp(5),
                        rs.getTimestamp(6),
                        rs.getString(7),
                        rs.getInt(8)
                );
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
    public int getMaxID(){
        int max=0;
        try {
            String sql = "SELECT MAX(c.id) FROM categories c;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                max=rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }
}
