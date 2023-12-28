package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Product implements Serializable {
    private int id;
    private int categoryID;
    private String productName;
    private int price;
    private String status;
    private int thumbnailID;
    private String imgURL;
    private  String description;
    private String stoneType;
    private String stoneColor;
    private String weight;

    private String size;

    //New Product
    private boolean sale;
    private boolean hot;
    private boolean description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String color;
    private String weight;
    private String size;
    private String opacity;
    private int inventoriesID;

    public Product(int id, int categoryID, String productName, int price, String status, String imgURL, boolean sale, boolean hot, boolean description, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String color, String weight, String opacity, String size, int inventoriesID) {
        this.id = id;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.imgURL = imgURL;
        this.sale = sale;
        this.hot = hot;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.color = color;
        this.weight = weight;
        this.size = size;
        this.opacity = opacity;
        this.inventoriesID = inventoriesID;
    }

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

    public Product(String imgURL, String productName, int price) {
        this.productName=productName;
        this.price = price;
        this.imgURL = imgURL;
    }

    public Product(int id, String productName, int price, String status, String description, String imgURL) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.imgURL = imgURL;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public String getStoneType() {
        return stoneType;
    }

    public void setStoneType(String stoneType) {
        this.stoneType = stoneType;
    }

    public String getStoneColor() {
        return stoneColor;
    }

    public void setStoneColor(String stoneColor) {
        this.stoneColor = stoneColor;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + "\n" +
                ", price=" + price +
                ", thumbnail='" + imgURL + "\t" +
                "}\n";
    }
}

