package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    ArrayList<Product> products=new ArrayList<>();
    public void addProduct(Product product){
        products.add(product);
    }
}
