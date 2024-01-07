package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Inventory;
import vn.edu.hcmuaf.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private static ProductDAO productDAO;
    private Map<Integer, String> productStatus = new HashMap<>();

    public ProductService() throws SQLException {
        this.productDAO = ProductDAO.getInstance();
    }

    public String classifyStatus(Integer quantity) {
        String status;

        if (quantity == null) {
            status = "Ngưng bán";
        } else if (quantity == 0) {
            status = "Hết hàng";
        } else {
            status = "Đặt hàng";
        }

        return status;
    }

    public ArrayList<Product> getListProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            ResultSet productRS = productDAO.getListProductWithImage();
            ResultSet inventoriesRS = productDAO.getInventories();

            Map<Integer, Integer> productQuantities = new HashMap<>();

            while (inventoriesRS.next()) {
                int productID = inventoriesRS.getInt("product_id");
                Integer quantity = (Integer) inventoriesRS.getObject("quantity");

                // Lấy status từ phương thức classifyStatus
                String status = classifyStatus(quantity);

                productQuantities.put(productID, quantity);

                // Gọi phương thức classifyStatus và lưu kết quả vào productStatus
                productStatus.put(productID, status);
            }

            while (productRS.next()) {
                int productID = productRS.getInt("id");
                String imgURL = productRS.getString("img_url");
                String productName = productRS.getString("product_name");
                int price = productRS.getInt("price");
                Integer quantity = productQuantities.get(productID);

                // Lấy status từ Map productStatus
                String status = productStatus.get(productID);

                Product product = new Product(productID, productName, imgURL, price, status);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}


