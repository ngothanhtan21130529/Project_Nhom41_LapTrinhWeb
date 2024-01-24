package vn.edu.hcmuaf.service;


import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;

import java.util.ArrayList;

public class PrintProductService {
    private ProductDAO productDAO;

    public PrintProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public PrintProductService() {
        productDAO = new ProductDAO();
    }

    //lấy ra toàn bộ danh sách sản phẩm
    public ArrayList<Product> getListProductFull() {
        return productDAO.getListProductFull();
    }
}
