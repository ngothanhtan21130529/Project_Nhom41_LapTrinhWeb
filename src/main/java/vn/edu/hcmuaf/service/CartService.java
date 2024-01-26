package vn.edu.hcmuaf.service;

import vn.edu.hcmuaf.model.Cart;
import vn.edu.hcmuaf.model.Product;

public class CartService {
    public static void addProduct(Product product) {
        if (Cart.products.isEmpty()) {
            Cart.addProduct(product);
        } else {
            for (Product item : Cart.products) {
                if (item.getImgURL().equalsIgnoreCase(product.getImgURL())) {
                    if (item.getProductName().equalsIgnoreCase(product.getProductName())) {
                        if (item.getPrice() == product.getPrice()) {
                            return;
                        } else {
                            Cart.addProduct(product);
                        }
                    }
                }
            }
        }
    }

    public static void removeProduct(Product product) {
        if (Cart.products.isEmpty()) {
            return;
        } else {
            for (Product item : Cart.products) {
                if (item.getImgURL().equalsIgnoreCase(product.getImgURL())) {
                    if (item.getProductName().equalsIgnoreCase(product.getProductName())) {
                        if (item.getPrice() == product.getPrice()) {
                            Cart.removeProduct(product);
                        }
                    }
                }
            }
        }
    }
}