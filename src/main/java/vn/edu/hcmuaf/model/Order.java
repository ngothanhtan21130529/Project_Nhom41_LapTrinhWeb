package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private int id;
    private int userID;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int totalPrice;
    private String fullName;
    private String status;
    private User user;
    private String phone;
    private String address;
    public Order(int id, int userID, Timestamp createdAt, Timestamp updatedAt, int totalPrice) {
        this.id = id;
        this.userID = userID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalPrice = totalPrice;
    }

    public Order() {

    }
    public Order(int id, String fullName, int totalPrice, Timestamp createdAt, Timestamp updatedAt, String status){
        this.id=id;
        this.fullName=fullName;
        this.totalPrice=totalPrice;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.status=status;
    }
    public Order(int id, int userID, Timestamp createdAt, int totalPrice, User user) {
        this.id = id;
        this.userID = userID;
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.user = user;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userID=" + userID +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", totalPrice=" + totalPrice +
                ", fullName='" + fullName + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
