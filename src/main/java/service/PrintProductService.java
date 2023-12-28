package service;

import DAO.CategoryDAO;
import DAO.ImageDAO;
import DAO.ProductDAO;
import model.Category;
import model.Product;

import java.util.ArrayList;

public class PrintProductService {
    ProductDAO productDAO;
    ImageDAO imageDAO;

    public PrintProductService(ProductDAO productDAO, ImageDAO imageDAO) {
        this.productDAO = productDAO;
        this.imageDAO = imageDAO;
    }

    public ArrayList<Category> getListProductFull() {
//        return productDAO.get();
    }

    public ArrayList<Product> printProducts(int index, int size){
        ArrayList<Product> productArrayList = get();
        ArrayList<Category> result=new ArrayList<>();
        for (int i = (index*size)-(size-1); i < (index*size); i++) {
            result.add(categoryArrayList.get(i));
        }
        return result;
    }
}
