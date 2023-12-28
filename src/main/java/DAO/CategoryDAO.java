package DAO;

import connection.MySqlConnection;
import model.Category;
import model.Image;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
            ps.setInt(4, c.getImage().getId());
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
                    "c.updated_at=?, c.status=?, c.img_id=? " +
                    "where c.id=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setTimestamp(2, c.getUpdatedAt());
            ps.setString(3, c.getStatus());
            ps.setInt(4, c.getImage().getId());
            ps.setInt(5, c.getId());
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

    public static int count() {
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

    public static ArrayList<Category> search(int index) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String query = "SELECT c.id, c.category_name, i.img_url, c.created_at, " +
                    "c.updated_at, c.deleted_at, c.status " +
                    "from categories c join images i on c.img_id=i.id " +
                    "limit 3 offset ?;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("category_name"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getTimestamp("deleted_at"),
                        rs.getString("status"),
                        rs.getString("img_url")
                );
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static ArrayList<Category> search() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String query = "SELECT c.id, c.category_name, i.img_url, c.created_at, " +
                    "c.updated_at, c.deleted_at, c.status " +
                    "from categories c join images i on c.img_id=i.id " +
                    "limit 3 offset 0;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("category_name"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getTimestamp("deleted_at"),
                        rs.getString("status"),
                        rs.getString("img_url")
                );
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static Category findByID(Category c, int index, int size) {
        try {
            String query = "with res as (select row_number() over (order by c.id asc) \n" +
                    "             as r, c.id, c.category_name, i.img_url, c.created_at,\n" +
                    "             c.updated_at, c.deleted_at, c.status\n" +
                    "             from categories c join images i on c.img_id=i.id \n" +
                    "             where c.id like ?) \n" +
                    "             select * from res where r between (?*?)-(?-1) and (?*?);";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("category_name"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at"),
                        rs.getTimestamp("deleted_at"),
                        rs.getString("status"),
                        rs.getString("img_url")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Category> getListCategoryFull() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String query = "select c.id, c.category_name, i.img_url, c.created_at, \n" +
                    "c.updated_at, c.deleted_at, c.status \n" +
                    "from categories c join images i;";
            Connection con = MySqlConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getTimestamp(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
