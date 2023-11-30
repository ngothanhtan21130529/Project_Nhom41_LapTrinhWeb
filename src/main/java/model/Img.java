package model;

import java.io.Serializable;
import java.util.Date;

public class Img implements Serializable {
    private int id;
    private String imgUrl;
    private String name;
    private Date createAt;
    private Date upadatedAt;
    public Img(int id, String imgUrl, String name, Date createAt, Date upadatedAt) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.createAt = createAt;
        this.upadatedAt = upadatedAt;
    }

    public Img() {
        super();
    }

    public Img(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
