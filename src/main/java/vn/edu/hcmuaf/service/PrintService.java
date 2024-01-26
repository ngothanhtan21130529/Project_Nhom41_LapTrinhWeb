package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.dao.UserDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;

import java.util.ArrayList;

public class PrintService {
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ProductDAO productDAO = new ProductDAO();
    private UserDAO userDAO = new UserDAO();
    private OrderDAO orderDAO=new OrderDAO();

    public PrintService() {
        this.categoryDAO = new CategoryDAO();
        this.productDAO = new ProductDAO();
        this.userDAO = new UserDAO();
        this.orderDAO= new OrderDAO();
    }

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
    public ArrayList<Order> getListDistinctOrderFull(){
        return orderDAO.getListDistinctOrderFull();
    }
}
