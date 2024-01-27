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
    private String description;
    private String stoneType;
    private String stoneColor;
    private String weight;
    private String size;
    //New Product
    private int sale;
    private boolean hot;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private String opacity;
    private int inventoriesID;
    private Category category;
    private String cuttingGrindingShape;
    private String material;
    private int quantity;
    private int totalPrice;
    public Product() {
    }

    public Product(int id, String productName, int categoryID, String imgURL,
                   int price, int sale, boolean hot, String description,
                   Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt,
                   String stoneColor, String weight, String size, String opacity,
                   String status, String cuttingGrindingShape, String material) {
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
        this.stoneColor = stoneColor;
        this.weight = weight;
        this.size = size;
        this.opacity = opacity;
        this.cuttingGrindingShape=cuttingGrindingShape;
        this.material=material;
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


    public Product(int id, String productName, int price, String imgURL) {
        this.id = id;

        this.productName = productName;
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


    public Product(String productName) {
        this.productName = productName;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public int getInventoriesID() {
        return inventoriesID;
    }

    public void setInventoriesID(int inventoriesID) {
        this.inventoriesID = inventoriesID;
    }

    public String getCuttingGrindingShape() {
        return cuttingGrindingShape;
    }

    public void setCuttingGrindingShape(String cuttingGrindingShape) {
        this.cuttingGrindingShape = cuttingGrindingShape;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", description='" + description + '\'' +
                ", stoneColor='" + stoneColor + '\'' +
                ", weight='" + weight + '\'' +
                ", size='" + size + '\'' +
                ", sale=" + sale +
                ", hot=" + hot +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", opacity='" + opacity + '\'' +
                ", inventoriesID=" + inventoriesID +
                ", cuttingGrindingShape='" + cuttingGrindingShape + '\'' +
                ", category=" + category +
                ", material='" + material + '\'' +
                '}';
    }
}

