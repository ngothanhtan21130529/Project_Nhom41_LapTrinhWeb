package model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id;
    private int userId;
    private int productDetailsID;
    private String commentContent;
    private String imgURL;

    public Comment(int id, int userId, int productDetailsID, String commentContent, String imgURL) {
        this.id = id;
        this.userId = userId;
        this.productDetailsID = productDetailsID;
        this.commentContent = commentContent;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductDetailsID() {
        return productDetailsID;
    }

    public void setProductDetailsID(int productDetailsID) {
        this.productDetailsID = productDetailsID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
