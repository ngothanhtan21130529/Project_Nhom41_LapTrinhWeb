package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;

import java.sql.SQLException;

public class ProductService {
    public int getProductid(String productname) throws SQLException {
        return     ProductDAO.getInstance().findIdProduct(productname);
    }
    public String getProductImg(String productname) throws SQLException {
        return ProductDAO.getInstance().getThumbnail(productname);
    }
}
