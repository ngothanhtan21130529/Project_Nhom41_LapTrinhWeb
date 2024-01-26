package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.model.Category;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class PrintCategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public PrintCategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public PrintCategoryService() {
        categoryDAO = new CategoryDAO();
    }

    //lấy ra toàn bộ danh sách danh mục
    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }
}
