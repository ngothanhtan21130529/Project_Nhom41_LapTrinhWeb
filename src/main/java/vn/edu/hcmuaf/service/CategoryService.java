package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;

public class CategoryService {
    private CategoryDAO dao;

    public CategoryService() {
        this.dao=new CategoryDAO();
    }

    public CategoryService(CategoryDAO dao) {
        this.dao = dao;
    }

    public void addCategory(Category category){
        dao.insert(category);
    }

    public void deleteCategory(Category category){
        dao.delete(category);
    }

    public void updateCategory(Category category){
        dao.update(category);
    }
    public int getMaxID(){
        return dao.getMaxID()+1;
    }
}
