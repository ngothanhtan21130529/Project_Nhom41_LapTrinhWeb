package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Category implements Serializable {
    private int id;
    private String categoryName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String status;
    private int imgID;
    private String imgURL;

    public Category(int id, String categoryName, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String status, int imgID) {
        this.id = id;
        this.categoryName = categoryName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.status = status;
        this.imgID = imgID;
    }

    public Category(int id, String categoryName, String imgURL) {
        this.id = id;
        this.categoryName = categoryName;
        this. imgURL = imgURL;
    }

    public Category(int id, String categoryName) {
        this.id=id;
        this.categoryName=categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
