package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;
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
    private ProductDAO productDAO;
    private Map<Integer, String> productStatus = new HashMap<>();

    public ProductService() throws SQLException {
        this.productDAO = ProductDAO.getInstance();
    }

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    //lấy danh sách sản phẩm
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

    public ArrayList<Product> getListProductNotJewelry() {
        ResultSet notJewerlyRS = productDAO.getListProductNotJewerly();
        return getProductList(notJewerlyRS);
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
                String material = productResultSet.getString("material");
                String color = productResultSet.getString("color");
                String size = productResultSet.getString("size");
                String cuttingType = productResultSet.getString("cutting_grinding_type");
                String weight = productResultSet.getString("weight");
                String opacity = productResultSet.getString("opacity");

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
                productDetail.setMaterial(material);
                productDetail.setColor(color);
                productDetail.setSize(size);
                productDetail.setCuttingGrindingType(cuttingType);
                productDetail.setWeight(weight);
                productDetail.setOpacity(opacity);
            }

            return productDetail;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getImages(ResultSet productImagesResultSet) throws SQLException {
        List<String> images = new ArrayList<>();
        while (productImagesResultSet.next()) {
            String imageURL = productImagesResultSet.getString("img_url");
            images.add(imageURL);
        }
        return images;
    }

    private int getQuantityFromInventories(ResultSet inventoriesResultSet, int productID) throws SQLException {
        while (inventoriesResultSet.next()) {
            int inventoryProductID = inventoriesResultSet.getInt("product_id");
            if (inventoryProductID == productID) {
                return inventoriesResultSet.getInt("quantity");
            }
        }
        return 0;
    }

    private String getStoneType(ResultSet productCategoryNameResultSet) throws SQLException {
        if (productCategoryNameResultSet.next()) {
            return productCategoryNameResultSet.getString("category_name");
        }
        return null; // Hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
    }

    public ArrayList<Product> getListProductWithImageByCategoryID(int categoryId) throws SQLException {
        if (productDAO == null) {
            this.productDAO = new ProductDAO();
        }
        ArrayList<Product> products = new ArrayList<>();

        try {
            // Gọi phương thức từ DAO để lấy danh sách sản phẩm với hình ảnh dựa trên ID của danh mục
            ResultSet resultSet = productDAO.getListProductWithImageByCategoryID(categoryId);

            // Chuyển đổi ResultSet thành danh sách đối tượng Product
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategoryID(resultSet.getInt("category_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setImgURL(resultSet.getString("img_url"));
                int price = resultSet.getInt("price");
                product.setPrice(resultSet.getInt("price"));
                // Lấy số lượng từ bảng inventories
                int productID = resultSet.getInt("id");
                ResultSet inventoriesResultSet = productDAO.getInventories();
                int quantity = getQuantityFromInventories(inventoriesResultSet, productID);

                // Xử lý thuộc tính trạng thái
                product.setStatus(classifyStatus(quantity));

                products.add(product);
            }
        } catch (SQLException e) {
            // Xử lý exception nếu cần thiết
            e.printStackTrace();
        }

        return products;
    }
    public static void main(String[] args) {
        try {
            // Tạo đối tượng ProductService
            ProductService productService = new ProductService();

            // Gọi phương thức để lấy danh sách sản phẩm theo categoryId
            int categoryId = 2;
            ArrayList<Product> productList = productService.getListProductWithImageByCategoryID(categoryId);

            // In ra thông tin của từng sản phẩm
            for (Product product : productList) {
                System.out.println("Product ID: " + product.getId());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Status: " + product.getStatus());
                System.out.println("Status: " + product.getCategoryID());
                System.out.println("------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}