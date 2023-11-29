package model;

import java.sql.Timestamp;

public class Category {
    private int id;
    private String categoryName;
    private Timestamp createAt;
    private Timestamp updateAt;
    public Category(int id, String categoryName, Timestamp createAt, Timestamp updateAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Category() {
        super();
    }

    public Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
