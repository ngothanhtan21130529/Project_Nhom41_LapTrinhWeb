package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Category implements Serializable {
    private int id;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String status;
    private int imgID;
    private String imgUrl;

    public Category(int id, String categoryName, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String status, int imgID) {
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
        this.imgUrl = imgUrl;
    }

    public Category() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public LocalDateTime getDeletedAt() { return deletedAt; }

    public void setDeletedAt(LocalDateTime deletedAt) { this.deletedAt = deletedAt; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getImgID() { return imgID; }

    public void setImgID(int imgID) { this.imgID = imgID; }

    public String getImgURL() { return imgUrl; }

    public void setImgURL(String imgURL) { this.imgUrl = imgURL; }

    public String getImageUrl() {

        return imgUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", status='" + status + '\'' +
                ", imgID=" + imgID +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
