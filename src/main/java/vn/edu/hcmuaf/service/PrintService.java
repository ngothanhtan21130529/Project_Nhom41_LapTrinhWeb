package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.*;
import vn.edu.hcmuaf.model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PrintService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ProductDAO productDAO = new ProductDAO();
    private UserDAO userDAO = new UserDAO();
    private OrderDAO orderDAO=new OrderDAO();
    private FeedbackDAO feedbackDAO=new FeedbackDAO();


    //lấy ra danh sách toàn bộ người dùng
    public ArrayList<User> getListUserFull() {
        return userDAO.getListUserFull();
    }

    //lấy ra toàn bộ danh sách sản phẩm
    public ArrayList<Product> getListProductFull() {
        return productDAO.getListProductFull();
    }

    //lấy ra toàn bộ danh sách danh mục
    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }
    //lấy ra danh sách hoá đơn độc nhất
    public ArrayList<Order> getListDistinctOrderFull(){
        return orderDAO.getListDistinctOrderFull();
    }
    //lấy ra danh sách nhận xét
    public ArrayList<Feedback> getFullListFeedBack() throws SQLException {
        return feedbackDAO.getFullListFeedBack();
    }
    //lấy ra danh sách tên phân loại
    public ArrayList<Category> getNameCategory(){
        return categoryDAO.getNameCategory();
    }
    //lấy ra danh sách tồn kho của sản phẩm
    public ArrayList<Product> getProductWithInventories() throws SQLException {
        return productDAO.getProductWithInventories();
    }
}
