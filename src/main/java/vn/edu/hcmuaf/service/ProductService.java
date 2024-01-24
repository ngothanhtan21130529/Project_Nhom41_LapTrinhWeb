package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Image;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.ProductDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public ProductDetail getProductByID(int productID) {
        ResultSet productResultSet = productDAO.getProductByID(productID);
        ResultSet inventoriesResultSet = productDAO.getInventories();
        ResultSet productImagesResultSet = productDAO.getProductImagesByID(productID);
        ResultSet productCategoryNameResultSet = productDAO.getProductCategoryNameByID(productID);

        try {
            ProductDetail productDetail = null;

            // Đọc dữ liệu từ ResultSet productResultSet
            if (productResultSet.next()) {
                int id = productResultSet.getInt("id");
                String productName = productResultSet.getString("product_name");
                int price = productResultSet.getInt("price");
                int sale = productResultSet.getInt("sale");
                String description = productResultSet.getString("description");
                String imgURL = productResultSet.getString("img_url");

                // Đọc dữ liệu từ ResultSet inventoriesResultSet
                int quantity = getQuantityFromInventories(inventoriesResultSet, id);

                // Đọc dữ liệu từ ResultSet productCategoryNameResultSet
                String stoneType = getStoneType(productCategoryNameResultSet);

                // Đọc dữ liệu từ ResultSet productImagesResultSet
                List<String> images = getImages(productImagesResultSet);

                // Tạo đối tượng ProductDetail
                productDetail = new ProductDetail();
                productDetail.setId(id);
                productDetail.setProductName(productName);
                productDetail.setPrice(price);
                productDetail.setSale(sale);
                productDetail.setDescription(description);
                productDetail.setImgURL(imgURL);
                productDetail.setStatus(classifyStatus(quantity));
                productDetail.setStoneType(stoneType);
                productDetail.setImages(images);
            }

            return productDetail;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getQuantityFromInventories(ResultSet inventoriesResultSet, int productID) throws SQLException {
        while (inventoriesResultSet.next()) {
            int inventoryProductID = inventoriesResultSet.getInt("product_id");
            if (inventoryProductID == productID) {
                return inventoriesResultSet.getInt("quantity");
            }
        }
        return 0; // Hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
    }

    private String getStoneType(ResultSet productCategoryNameResultSet) throws SQLException {
        if (productCategoryNameResultSet.next()) {
            return productCategoryNameResultSet.getString("category_name");
        }
        return null; // Hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
    }

    private List<String> getImages(ResultSet productImagesResultSet) throws SQLException {
        List<String> images = new ArrayList<>();
        while (productImagesResultSet.next()) {
            String imageURL = productImagesResultSet.getString("img_url");
            images.add(imageURL);
        }
        return images;
    }


    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();

        // ID của sản phẩm cần hiển thị thông tin
        int productId = 2;

        // Gọi phương thức getProductByID từ lớp ProductService
        ProductDetail productDetail = productService.getProductByID(productId);

        // Kiểm tra nếu productDetail không null thì hiển thị thông tin
        if (productDetail != null) {
            System.out.println("Thông tin sản phẩm:");
            System.out.println("ID: " + productDetail.getId());
            System.out.println("Tên sản phẩm: " + productDetail.getProductName());
            System.out.println("Giá: " + productDetail.getPrice());
            System.out.println("Trạng thái: " + productDetail.getStatus());
            System.out.println("Ảnh URL: " + productDetail.getImgURL());
            System.out.println("Sale: " + productDetail.getSale());
            System.out.println("loại: " + productDetail.getStoneType());
            System.out.println("Mô tả: " + productDetail.getDescription());

            // Hiển thị danh sách hình ảnh
            List<String> images = productDetail.getImages();
            if (images != null && !images.isEmpty()) {
                System.out.println("Danh sách hình ảnh:");
                for (String imageURL : images) {
                    System.out.println(imageURL);
                }
            } else {
                System.out.println("Không có hình ảnh.");
            }

            // Thêm hiển thị các thuộc tính khác theo cần thiết
        } else {
            System.out.println("Không tìm thấy thông tin sản phẩm có ID = " + productId);
        }
    }
}


