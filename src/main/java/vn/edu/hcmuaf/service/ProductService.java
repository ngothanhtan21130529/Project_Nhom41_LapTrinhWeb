package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;

import java.util.ArrayList;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = ProductDAO.getInstance();
    }

    public ArrayList<Product> getListProduct(){

        return productDAO.getListProduct();
    }
}
