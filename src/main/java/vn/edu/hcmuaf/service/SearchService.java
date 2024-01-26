package vn.edu.hcmuaf.service;


import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;

import java.util.ArrayList;

public class SearchService {
    ProductDAO productDAO;
    ImageDAO imageDAO;
    CategoryDAO categoryDAO;

    public SearchService() {
        this.categoryDAO = new CategoryDAO();
        this.productDAO = new ProductDAO();
        this.imageDAO = new ImageDAO();
    }

    public SearchService(ProductDAO productDAO, ImageDAO imageDAO, CategoryDAO categoryDAO) {
        this.productDAO = productDAO;
        this.imageDAO = imageDAO;
        this.categoryDAO = categoryDAO;
    }

    //lấy ra toàn bộ danh sách danh mục
    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }

    //ấy ra toàn bộ danh sách hình ảnh
    public ArrayList<Image> getListImageFull() {
        return imageDAO.getListImageFull();
    }

    //tìm kiếm danh mục dựa trên 1 số stt cụ thể
    public Category findCategoryById(int id) {
        ArrayList<Category> categories = getListCategoryFull();
        for (Category category : categories) {
            if (category.getId() == id) return category;
        }
        return null;
    }

    //tìm kiếm hình ảnh dựa trên 1 số stt cụ thể
    public Image findImageById(int id) {
        ArrayList<Image> imageArrayList = getListImageFull();
        for (Image image : imageArrayList) {
            if(image.getId()==id) {
                return image;
            }
        }
        return null;
    }

}
