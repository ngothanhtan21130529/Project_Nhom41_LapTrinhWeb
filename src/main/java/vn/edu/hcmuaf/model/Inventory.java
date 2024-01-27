package vn.edu.hcmuaf.model;

import java.io.Serializable;

public class Inventory implements Serializable {
    private int id;
    private int quantity;
    private int productId;
    private String productName;

    public Inventory(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
