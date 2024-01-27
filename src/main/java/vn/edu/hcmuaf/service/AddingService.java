package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.InventoriesDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class AddingService {
    ImageService imageService = new ImageService();
    CategoryService categoryService = new CategoryService();
    OrderDetailSerivce orderDetailSerivce = new OrderDetailSerivce();
    OrderService orderService = new OrderService();
    SearchService service = new SearchService();
    ProductService productService = new ProductService();
    InventoriesDAO inventoriesDAO=new InventoriesDAO();
    public AddingService() {
        this.imageService = new ImageService();
        this.categoryService = new CategoryService();
        this.orderDetailSerivce = new OrderDetailSerivce();
    }

    public Category CategoryAdding(String categoryName, String status, String imgURL, String imageName) {
        Image image = new Image(imageService.getMaxID(), imgURL, imageName);
        imageService.addImage(image);
        Category category = new Category(categoryService.getMaxID(), categoryName, status, image.getId());
        categoryService.addCategory(category);
        return category;
    }

    public void updateStatusOrderDetails(int id, String status) {
        Order order = service.getOrderByID(id);
        order.setStatus(status);
        orderService.update(order);
    }

    public String generateNewName(String oldName, String productName, int i) {
        return productName +" "+ i;
    }

    public Product productAdding(int id, int price, boolean hot, int sale, String color, String opacity,
                                 String size, String shape, String material, String name, String description,
                                 String content, String status, int thumnailID,
                                 String weight, int quantity) throws SQLException {
        Category category = service.findCategoryById(id);
        Product product = new Product();
        int productId=productService.getMaxID();
        product.setId(productId);
        product.setCategoryID(category.getId());
        product.setProductName(name);
        product.setPrice(price);
        product.setStatus(status);
        product.setThumbnailID(thumnailID);
        product.setSale(sale);
        product.setHot(hot);
        product.setDescription(description);
        product.setStoneColor(color);
        product.setWeight(weight);
        product.setOpacity(opacity);
        product.setSize(size);
        product.setCuttingGrindingShape(shape);
        product.setMaterial(material);
        product.setDescription(content);
        product.setQuantity(quantity);
        Inventory inventory=new Inventory();
        inventory.setId(inventoriesDAO.getMaxID()+1);
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);
        productService.addProduct(product);
        inventoriesDAO.insert(inventory);
        return product;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new ProductService().getMaxID());
    }
}
