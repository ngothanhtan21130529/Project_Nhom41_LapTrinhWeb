package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private int id;
    private int userID;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int totalPrice;

    public Order(int id, int userID, Timestamp createdAt, Timestamp updatedAt, int totalPrice) {
        this.id = id;
        this.userID = userID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
