package service;

import DAO.CategoryDAO;
import DAO.ImageDAO;
import DAO.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SearchService {
    ProductDAO productDAO;
    ImageDAO imageDAO;
    CategoryDAO categoryDAO;

    public SearchService(ProductDAO productDAO, ImageDAO imageDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.imageDAO = imageDAO;
        this.categoryDAO = categoryDAO;
    }

    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }

    public Category findCategoryById(int id) {
        ArrayList<Category> categories = getListCategoryFull();
        for (Category category : categories) {
            if(category.getId()==id) return category;
        }
        return null;
    }


}
