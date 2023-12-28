package vn.edu.hcmuaf.model;

import java.io.Serializable;

public class Image implements Serializable {
    private static int id;
    private static String imgURL;
    private static String imageName;


    public Image(String imgURL, String imageName) {
        this.imgURL = imgURL;
        this.imageName = imageName;
    }

    public Image(int id, String imgURL, String imageName) {
        this.id = id;
        this.imgURL = imgURL;
        this.imageName = imageName;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public static String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
