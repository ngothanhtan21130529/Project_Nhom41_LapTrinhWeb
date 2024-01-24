package vn.edu.hcmuaf.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    public static ArrayList<Product> products=new ArrayList<>();
    public static void  addProduct(Product product){
        products.add(product);
    }
    public static void removeProduct(Product product){
        products.remove(product);
    }
}
