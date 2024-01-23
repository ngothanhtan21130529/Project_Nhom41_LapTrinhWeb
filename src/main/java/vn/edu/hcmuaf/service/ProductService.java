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
        ResultSet productCategoryName = productDAO.getProductCategoryNameByID(productID);

        try {
            if (productResultSet.next()) {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setId(productResultSet.getInt("id"));
                productDetail.setProductName(productResultSet.getString("product_name"));
                productDetail.setPrice(productResultSet.getInt("price"));
                productDetail.setStatus(classifyStatus(getQuantityFromInventories(inventoriesResultSet, productID)));
                productDetail.setImgURL(productResultSet.getString("img_url"));
                productDetail.setDescription(productResultSet.getString("description"));
                productDetail.setStoneType(productCategoryName.getString("category_name"));
                productDetail.setColor(productResultSet.getString("color"));
                productDetail.setWeight(productResultSet.getString("weight"));
                productDetail.setSize(productResultSet.getString("size"));
                productDetail.setOpacity(productResultSet.getString("opacity"));
                productDetail.getMaterial(productResultSet.getString("material"));
                productDetail.setCuttingGrindingType(productResultSet.getString("cutting_grinding_type"));

                // Lấy danh sách hình ảnh từ ResultSet và set vào productDetail
                List<String> images = new ArrayList<>();
                while (productImagesResultSet.next()) {
                    String imageURL = productImagesResultSet.getString("img_url");
                    images.add(imageURL);
                }
                productDetail.setImages(images);

                return productDetail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Integer getQuantityFromInventories(ResultSet inventoriesResultSet, int productID) throws SQLException {
        while (inventoriesResultSet.next()) {
            int inventoryProductID = inventoriesResultSet.getInt("product_id");
            if (inventoryProductID == productID) {
                return inventoriesResultSet.getInt("quantity");
            }
        }
        return null;
    }
}


