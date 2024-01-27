package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.dao.InventoriesDAO;
import vn.edu.hcmuaf.model.Inventory;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;

import java.sql.SQLException;

public class UpdateService {
    ProductService productService=new ProductService();
    SearchService service=new SearchService();
    UserService userService=new UserService();
    InventoriesDAO inventoriesDAO=new InventoriesDAO();
    public void updateQuantityProduct(int id, int quantity) throws SQLException {
        Inventory inventories = service.getInventoryById(id);
        inventories.setQuantity(quantity);
        inventoriesDAO.update(inventories);
    }
    public void updateUserInfo(int id, String role, String username, String name, String password){
        User user=service.findUserById(id);
        user.setRoleName(role);
        user.setUserName(username);
        user.setName(name);
        user.setPassword(password);
    }

    public Product updateProduct(int productID, int categoryID, int price, boolean hot, int sale, String color, String opacity,
                                 String size, String shape, String material, String name, String description,
                                 String content, String status, int thumnailID,
                                 String weight, int quantity){
        Product product=service.getProductWithId(productID);
        product.setCategoryID(categoryID);
        product.setPrice(price);
        product.setHot(hot);
        product.setSale(sale);
        product.setStoneColor(color);
        product.setOpacity(opacity);
        product.setSize(size);
        product.setCuttingGrindingShape(shape);
        product.setMaterial(material);
        product.setProductName(name);
        product.setDescription(description);
        product.setDescription(content);
        product.setStatus(status);
        product.setThumbnailID(thumnailID);
        product.setWeight(weight);
        product.setQuantity(quantity);
        productService.updateProduct(product);
        return product;
    }
}
