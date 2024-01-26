package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;

public class AddingService {
    ImageService imageService = new ImageService();
    CategoryService categoryService = new CategoryService();

    public AddingService() {
        this.imageService = new ImageService();
        this.categoryService =  new CategoryService();
    }

    public Category CategoryAdding(String categoryName, String status, String imgURL, String imageName){
        Image image = new Image(imageService.getMaxID(),imgURL,imageName);
        imageService.addImage(image);
        Category category=new Category(categoryService.getMaxID(), categoryName, status, image.getId());
        categoryService.addCategory(category);
        return  category;
    }
}
