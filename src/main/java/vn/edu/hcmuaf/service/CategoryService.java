package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public CategoryService() {

    }

    public void addCategory(Category category) throws SQLException {
        categoryDAO.insert(category);
    }

    public void deleteCategory(Category category) {
        categoryDAO.delete(category);
    }

    public void updateCategory(Category category) {
        categoryDAO.update(category);
    }

    public int getMaxID() {
        return categoryDAO.getMaxID() + 1;
    }

    public ArrayList<String> getAllCategoryNames() {
        return categoryDAO.getAllCategoryNames();
    }

    public String getCategoryImage(int categoryId) {
        return categoryDAO.getImage(categoryId);
    }

    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();

        try (ResultSet categoryNamesRS = categoryDAO.getCategoryNames()) {
            while (categoryNamesRS.next()) {
                String categoryName = categoryNamesRS.getString("category_name");
                categoryNames.add(categoryName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryNames;
    }


    public ArrayList<Category> getAllGemCategories() throws SQLException {
        if (categoryDAO == null) {
            categoryDAO = new CategoryDAO();
        }
        ArrayList<Category> gemCategories = new ArrayList<>();
        try {
            // Gọi phương thức từ DAO để lấy danh sách categories không chứa ảnh đại diện
            ResultSet categoriesRS = categoryDAO.getCategoriesWithImage();

            // Chuyển đổi ResultSet thành danh sách đối tượng Category
            while (categoriesRS.next()) {
                Category category = new Category();
                category.setId(categoriesRS.getInt("category_id"));
                category.setCategoryName(categoriesRS.getString("category_name"));
                category.setImgURL(categoriesRS.getString("img_url"));

                gemCategories.add(category);
            }
        } catch (SQLException e) {
            // Xử lý exception nếu cần thiết
            e.printStackTrace();
        }

        return gemCategories;
    }

    public ArrayList<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}