package service;

import DAO.CategoryDAO;
import DAO.ImageDAO;
import model.Category;

import java.util.ArrayList;

public class PrintCategoryService {
    CategoryDAO categoryDAO;
    ImageDAO imageDAO;

    public PrintCategoryService(CategoryDAO categoryDAO, ImageDAO imageDAO) {
        this.categoryDAO = categoryDAO;
        this.imageDAO = imageDAO;
    }

    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }

    public ArrayList<Category> printCategories(int index, int size) {
        ArrayList<Category> categoryArrayList = getListCategoryFull();
        ArrayList<Category> result = new ArrayList<>();
        for (int i = (index * size) - (size - 1); i < (index * size); i++) {
            result.add(categoryArrayList.get(i));
        }
        return result;
    }

}
