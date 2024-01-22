package vn.edu.hcmuaf.model;

import java.util.List;

public class ProductDetail {
    private String productName;
    private int price;
    private String description;
    private List<String> imageUrls;

    public ProductDetail(String productName, int price, String description, List<String> imageUrls) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imageUrls = imageUrls;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
