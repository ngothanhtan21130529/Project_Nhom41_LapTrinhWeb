package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;

public class ImageService {
    private ImageDAO dao;

    public ImageService() {
        this.dao=new ImageDAO();
    }
    public ImageService(ImageDAO dao) {
        this.dao = dao;
    }
    public void addImage(Image image){
        dao.insert(image);
    }
    public void deleteImage(Image image){
        dao.delete(image);
    }
    public void updateImage(Image image){
        dao.update(image);
    }
    public int getMaxID(){
        return dao.getMaxID()+1;
    }

}