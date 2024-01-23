package vn.edu.hcmuaf.model;

import java.util.List;

public class ProductDetail {
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
    private Integer quantity;
    private String size;
    private String cuttingGrindingType;
    private String  material;
    private String color;
    List<String> images;
    String opacity;
    private int sale;
    private String hot;


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

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCuttingGrindingType() {
        return cuttingGrindingType;
    }

    public void setCuttingGrindingType(String cuttingGrindingType) {
        this.cuttingGrindingType = cuttingGrindingType;
    }

    public String getMaterial(String material) {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }
}
