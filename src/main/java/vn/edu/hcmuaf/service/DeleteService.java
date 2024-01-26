package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;

public class DeleteService {
    ImageService imageService = new ImageService();
    CategoryService categoryService = new CategoryService();
    SearchService searchService=new SearchService();

    public DeleteService() {
        this.imageService = new ImageService();
        this.categoryService = new CategoryService();
    }

    public void CategoryDeleting(int categoryId){
        Category category=searchService.findCategoryById(categoryId);
        Image image=searchService.findImageById(category.getImgID());
        imageService.deleteImage(image);
        categoryService.deleteCategory(category);
    }
}
