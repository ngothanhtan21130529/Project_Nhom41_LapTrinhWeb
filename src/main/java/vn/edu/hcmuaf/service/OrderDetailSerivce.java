package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.OrderDetailsDAO;
import vn.edu.hcmuaf.model.OrderDetail;

public class OrderDetailSerivce {
    OrderDetailsDAO orderDetailsDAO;

    public OrderDetailSerivce() {
        orderDetailsDAO=new OrderDetailsDAO();
    }
}
