package model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private int id;
    private Category category;
    private Img img;
    private String name;
    private boolean available;
    private int price;
    private String status;
    private Date createAt;
    private Date upadatedAt;

    public Product(int id, Category category, Img img, String name, boolean available, int price,
                   String status, Date createAt, Date upadatedAt) {
        this.id = id;
        this.category = category;
        this.img = img;
        this.name = name;
        this.available = available;
        this.price = price;
        this.status = status;
        this.createAt = createAt;
        this.upadatedAt = upadatedAt;
    }

    public Product() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpadatedAt() {
        return upadatedAt;
    }

    public void setUpadatedAt(Date upadatedAt) {
        this.upadatedAt = upadatedAt;
    }

}
