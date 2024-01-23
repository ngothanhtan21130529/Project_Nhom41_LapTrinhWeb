package vn.edu.hcmuaf.model;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private String imgURL;
    private String imageName;


    public Image(String imgURL, String imageName) {
        this.imgURL = imgURL;
        this.imageName = imageName;
    }

    public Image() {
    }

    public Image(int id, String imgURL, String imageName) {
        this.id = id;
        this.imgURL = imgURL;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "id="+id+" imgUrl="+imgURL+" imageName="+imageName;
    }

}
