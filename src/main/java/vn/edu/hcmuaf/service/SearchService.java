package vn.edu.hcmuaf.service;


import vn.edu.hcmuaf.dao.*;
import vn.edu.hcmuaf.database.MySqlConnection;
import vn.edu.hcmuaf.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchService {
    ProductDAO productDAO;
    ImageDAO imageDAO;
    CategoryDAO categoryDAO;
    OrderDAO orderDAO;
    OrderDetailsDAO orderDetailsDAO;

    public SearchService() {
        this.categoryDAO = new CategoryDAO();
        this.productDAO = new ProductDAO();
        this.imageDAO = new ImageDAO();
        this.orderDAO = new OrderDAO();
        this.orderDetailsDAO = new OrderDetailsDAO();
    }

    //lấy ra toàn bộ danh sách danh mục
    public ArrayList<Category> getListCategoryFull() {
        return categoryDAO.getListCategoryFull();
    }

    //lấy ra toàn bộ danh sách hình ảnh
    public ArrayList<Image> getListImageFull() {
        return imageDAO.getListImageFull();
    }

    public ArrayList<Order> getListOrderFull() {
        return orderDAO.getListDistinctOrderFull();
    }

    //lấy ra toàn bộ danh sách chi tiết đơn hàng
    public ArrayList<OrderDetail> getListOrderDetailsFull() {
        return orderDetailsDAO.getListOrderDetailFull();
    }

    //tìm kiếm danh mục dựa trên 1 số stt cụ thể
    public Category findCategoryById(int id) {
        ArrayList<Category> categories = getListCategoryFull();
        for (Category category : categories) {
            if (category.getId() == id) return category;
        }
        return null;
    }

    //tìm kiếm hình ảnh dựa trên 1 số stt cụ thể
    public Image findImageById(int id) {
        ArrayList<Image> imageArrayList = getListImageFull();
        for (Image image : imageArrayList) {
            if (image.getId() == id) {
                return image;
            }
        }
        return null;
    }

    //tìm kiếm danh sách chi tiết đơn hàng dựa trên 1 số stt cụ thể
    public ArrayList<OrderDetail> GetOrderDetailsListByID(int id) {
        ArrayList<OrderDetail> orderDetailArrayList = getListOrderDetailsFull();
        ArrayList<OrderDetail> list = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailArrayList) {
            if (orderDetail.getOrderID() == id) {
                list.add(orderDetail);
            }
        }
        return list;
    }

    public Order getOrderByID(int id) {
        ArrayList<Order> orderArrayList = getListOrderFull();
        for (Order order : orderArrayList) {
            if (order.getId() == id) return order;
        }
        return null;
    }
    public ArrayList<OrderDetail> getOrderDetails() throws SQLException {
        ArrayList<OrderDetail> orderDetailArrayList=new ArrayList<>();
        ResultSet productRS= productDAO.getProductQuantity();
        ResultSet orderDetailsRS=orderDetailsDAO.getProductFromOrderDetails();
        OrderDetail orderDetail=new OrderDetail();
        while (productRS.next()){
            while (orderDetailsRS.next()) {
                String productName = productRS.getString("product_name");
                int price = productRS.getInt("price");
                int quantity = orderDetailsRS.getInt("quantity_total");
                int total = price * quantity;
                total = orderDetailsRS.getInt("total_price_product");
                orderDetail.setProductName(productName);
                orderDetail.setPrice(price);
                orderDetail.setQuantity(quantity);
                orderDetail.setTotalPrice(total);

                orderDetailArrayList.add(orderDetail);
            }
        }
        return orderDetailArrayList;
    }
}
