package model;

import java.io.Serializable;

public class Image implements Serializable {
    private int id;
    private String imgURL;
    private int productDetailID;

    public Image(int id, String imgURL, int productDetailID) {
        this.id = id;
        this.imgURL = imgURL;
        this.productDetailID = productDetailID;
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

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }
}
