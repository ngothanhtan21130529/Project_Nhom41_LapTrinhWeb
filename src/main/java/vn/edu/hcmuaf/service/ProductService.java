package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() throws SQLException {
        this.productDAO = ProductDAO.getInstance();
    }

    public ArrayList<Product> getListProducts(){
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet productRS = productDAO.getListProductWithImage();
            ResultSet inventorysRS = productDAO.getInventories();

            Map<Integer, Integer> productQuantities = new HashMap<>();

            while (inventorysRS.next()){
                int productID = inventorysRS.getInt("id");
                int quantity = inventorysRS.getInt("quantity");

                productQuantities.put(productID, quantity);
            }
            while (productRS.next()){
                int productID = productRS.getInt("id");
                String thumbnailID = productRS.getString("img_url");
                int quantity = productQuantities.getOrDefault(productID, 0);
                String status;
                if (quantity == 0 ){
                    status = "Hết hàng";
                } else if (quantity >= 1 ) {
                    status = "Đặt hàng";
                } else {
                    status = "Ngừng bán";
                }

                Product product = new Product(productID, productRS.getString("product_name"), productRS.getInt("price"), thumbnailID, status);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
