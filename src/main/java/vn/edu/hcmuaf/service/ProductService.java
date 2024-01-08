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

//    quy ước trạng thái sản phẩm tự động
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


//    lấy danh sách sản phẩm
public ArrayList<Product> getProductList(ResultSet productRS) {
    ArrayList<Product> productList = new ArrayList<>();
    try {
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

            // Kiểm tra nếu quantity không là null
            if (quantity != null) {
                // Lấy status từ Map productStatus
                String status = productStatus.get(productID);

                Product product = new Product(productID, productName, imgURL, price, status);
                productList.add(product);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return productList;
}

    public ArrayList<Product> getListProducts() {
        ResultSet productRS = productDAO.getListProductWithImage();
        return getProductList(productRS);
    }

    public ArrayList<Product> getJewelryList() {
        ResultSet jewelryListRS = productDAO.getListJewlryWithImage();
        return getProductList(jewelryListRS);
    }


//    public static void main(String[] args) throws SQLException {
//        // Tạo một đối tượng của lớp chứa hàm getListProducts
//        ProductService yourClass = new ProductService(); // Thay YourClassName bằng tên thực tế của lớp chứa đoạn mã
//
//        // Gọi hàm getListProducts để lấy danh sách sản phẩm
//        ArrayList<Product> productList = yourClass.getListProducts();
//
//        // In ra thông tin của từng sản phẩm
//        for (Product product : productList) {
//            System.out.println("Product ID: " + product.getId());
//            System.out.println("Product Name: " + product.getProductName());
//            System.out.println("Image URL: " + product.getImgURL());
//            System.out.println("Price: " + product.getPrice());
//            System.out.println("Status: " + product.getStatus());
//            System.out.println("--------------");
//        }
//    }

}


