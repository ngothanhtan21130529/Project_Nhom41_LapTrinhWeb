package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() throws SQLException {
        this.categoryDAO = new CategoryDAO();
    }

    public ArrayList<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    public ArrayList<String> getAllCategoryNames() {
        return categoryDAO.getAllCategoryNames();
    }

    public String getCategoryImage(int categoryId) {
        return categoryDAO.getImage(categoryId);
    }

}