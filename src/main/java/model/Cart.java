package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cart implements Serializable {
   public static  ArrayList<Product> products=new ArrayList<>();
    public static ArrayList<Product> addProduct(Product product){
        products.add(product);
        return products;
    }
    public static ArrayList<Product> deleteProduct(Product product){
        for(int i=0;i<products.size();i++){
            if(products.get(i).equals(product)){
                products.remove(i);
                break;
            }
        }
        return products;
    }
}
