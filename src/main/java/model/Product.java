package model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private int categoryID;
    private String productName;
    private int price;
    private String status;
    private int thumbnailID;
    private String imgURL;

    public Product(int id, int categoryID, String productName, int price, String status, int thumbnailID) {
        this.id = id;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.thumbnailID = thumbnailID;
    }

    public Product(int id, String productName, int price, String status, String imgURL) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getThumbnailID() {
        return thumbnailID;
    }

    public void setThumbnailID(int thumbnailID) {
        this.thumbnailID = thumbnailID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}

