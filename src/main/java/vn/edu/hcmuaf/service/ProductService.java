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
                String imgURL = productRS.getString("img_url");
                String productName = productRS.getString("product_name");
                Integer quantity = (Integer) productQuantities.getOrDefault(productID, 0);
                int price = productRS.getInt("price");
                String status;
                if (quantity == null ){
                    status = "Ngưng bán";
                } else if (quantity >= 1 ) {
                    status = "Đặt hàng";
                } else {
                    status = "Hết hàng";
                }

                Product product = new Product(productID, productName, imgURL, price , status);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

        public static void main(String[] args) throws SQLException {
            ProductService productService = new ProductService();
            try {
                ArrayList<Product> products = productService.getListProducts();

                for (Product product : products) {
                    System.out.println("Product ID: " + product.getId());
                    System.out.println("Product Name: " + product.getProductName());
                    System.out.println("Price: " + product.getPrice());
                    System.out.println("img: " + product.getImgURL());
                    System.out.println("Status: " + product.getStatus());
                    System.out.println("------------------------");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
