package model;

import java.io.Serializable;
import java.util.Date;

public class ProductDetails implements Serializable {
    private int id;
    private String name;
    private int price;
    private int sale;
    private boolean hot;
    private String description;
    private int imgID;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String color;
    private String weight;
    private String size;
    private String opacity;
    private int status;
    private int productID;
    private int inventoriesID;

    public ProductDetails(int id, String name, int price, int sale, boolean hot, String description, int imgId,
                          Date createdAt, Date updatedAt, Date deletedAt, String color, String weight, String size,
                          String opacity, int status, int productId, int inventoriesId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.hot = hot;
        this.description = description;
        this.imgID = imgID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.color = color;
        this.weight = weight;
        this.size = size;
        this.opacity = opacity;
        this.status = status;
        this.productID = productID;
        this.inventoriesID = inventoriesID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice(int price) {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }

    public int getSale(int sale) {
        return sale;
    }

    public void setSale() {
        this.sale = sale;
    }

    public boolean isHot(boolean hot) {
        return hot;
    }

    public void setHot() {
        this.hot = hot;
    }

    public String getDescription(String description) {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public int getImgID(int imgID) {
        return imgID;
    }

    public void setImgID() {
        this.imgID = imgID;
    }

    public Date getCreatedAt(Date createdAt) {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt(Date deletedAt) {
        return deletedAt;
    }

    public void setDeletedAt() {
        this.deletedAt = deletedAt;
    }

    public Date getUpdatedAt(Date updatedAt) {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = updatedAt;
    }

    public String getColor(String color) {
        return color;
    }

    public void setColor() {
        this.color = color;
    }

    public String getWeight(String weight) {
        return weight;
    }

    public void setWeight() {
        this.weight = weight;
    }

    public String getSize(String size) {
        return size;
    }

    public void setSize() {
        this.size = size;
    }

    public String getOpacity(String opacity) {
        return opacity;
    }

    public void setOpacity() {
        this.opacity = opacity;
    }

    public int getStatus(int status) {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }

    public int getProductID(int productID) {
        return productID;
    }

    public void setProductID() {
        this.productID = productID;
    }

    public int getInventoriesID(int inventoriesID) {
        return inventoriesID;
    }

    public void setInventoriesID() {
        this.inventoriesID = inventoriesID;
    }
}
