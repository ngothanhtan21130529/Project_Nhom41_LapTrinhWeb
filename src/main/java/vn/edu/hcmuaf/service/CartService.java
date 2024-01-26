package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.model.Cart;
import vn.edu.hcmuaf.model.Product;

public class CartService {
    public static void addProduct(Product product) {
        boolean productExists = false;

        for (Product item : Cart.products) {
            if (item.getProductName().equalsIgnoreCase(product.getProductName())) {
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            Cart.addProduct(product);
        }
    }




    public static void removeProduct(Product product) {
        for (Product item : Cart.products) {
            if (item.getProductName().equalsIgnoreCase(product.getProductName())) {
                Cart.removeProduct(item);
                return;
            }
        }
    }
}


