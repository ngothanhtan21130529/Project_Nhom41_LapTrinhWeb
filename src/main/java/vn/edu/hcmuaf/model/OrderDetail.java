package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderDetail implements Serializable {
    private int id;
    private int productID;
    private int orderID;
    private int quantityTotal;
    private int totalPrice;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String status;
    private Order order;
    private Product product;
    public OrderDetail(int id, int productID, int orderID, int quantityTotal, int totalPrice, Timestamp createdAt, Timestamp updatedAt, String status) {
        this.id = id;
        this.productID = productID;
        this.orderID = orderID;
        this.quantityTotal = quantityTotal;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    //model for access data
    public OrderDetail(int id, int productID, int orderID, int quantityTotal, int totalPrice, Timestamp createdAt, String status, Order order, Product product) {
        this.id = id;
        this.productID = productID;
        this.orderID = orderID;
        this.quantityTotal = quantityTotal;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.status = status;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", productID=" + productID +
                ", orderID=" + orderID +
                ", quantityTotal=" + quantityTotal +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", order=" + order +
                '}';
    }
}
