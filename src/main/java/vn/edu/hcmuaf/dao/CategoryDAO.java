package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAOInterface {

    @Override
    public int insert(Object o) throws SQLException {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public Object selectById(Object o) {
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
}
