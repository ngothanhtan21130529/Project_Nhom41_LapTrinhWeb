package vn.edu.hcmuaf.dao;

import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.database.Queries;
import vn.edu.hcmuaf.model.Category;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

private Connection connection;

    public CategoryDAO() throws SQLException {
        this.connection = MySqlConnection.getConnection();
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_CATEGORIES);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setImgURL(rs.getString("img_url"));

                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public ArrayList<String> getAllCategoryNames() {
        ArrayList<String> categoryNames = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(Queries.GET_CATEGORY_NAMES);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String categoryName = rs.getString("category_name");
                categoryNames.add(categoryName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryNames;
    }

    public String getImage(int categoryId) {
        String imgURL = null;

        try (PreparedStatement ps = connection.prepareStatement(Queries.GET_IMAGE_BY_ID)) {
            ps.setInt(1, categoryId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    imgURL = rs.getString("img_url");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return imgURL;
    }



}
