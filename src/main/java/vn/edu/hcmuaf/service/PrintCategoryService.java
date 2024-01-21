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
    }

    //lấy ra toàn bộ danh sách danh mục
    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getInstance().getListCategoryFull();
    }

    //in ra danh sách danh mục trong quản lý danh mục theo từng trang với
    //mỗi trang là bao nhiêu sản phẩm
    public ArrayList<Category> printCategories(int index) {
        ArrayList<Category> result = new ArrayList<>();
        ArrayList<Category> categoryArrayList = getListCategoryFull();
        int j;
        for (int i = 0; i < categoryArrayList.size(); i++) {
            j = i - 1;
            result.add(categoryArrayList.get(j));
        }
        return result;
    }

    //đếm số trang cho việc in sản phẩm
    public static int countPage(int size) {
        CategoryDAO dao = new CategoryDAO();
        int count = dao.getInstance().count();
        int pageNum = count / size;
        if (count % size != 0) pageNum++;
        return pageNum;
    }
}
