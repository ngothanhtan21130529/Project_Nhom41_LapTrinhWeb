package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;

import java.sql.SQLException;

public class ProductService {
    private ProductDAO dao=new ProductDAO();
    public void addProduct(Product product){
        dao.insert(product);
    }
    public void deleteProduct(Product product){
        dao.delete(product);
    }
    public void updateProduct(Product product){
        dao.update(product);
    }
    public int getMaxID() throws SQLException {
        return dao.getMaxID()+1;
    }
}
