package vn.edu.hcmuaf.service;


import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;

import java.util.ArrayList;

public class PrintProductService {
    ProductDAO productDAO;
    ImageDAO imageDAO;

    public PrintProductService(ProductDAO productDAO, ImageDAO imageDAO) {
        this.productDAO = productDAO;
        this.imageDAO = imageDAO;
    }

    public ArrayList<Product> getListProductFull() {
        return productDAO.getListProductFull();
    }

    public ArrayList<Product> printProducts(int index, int size){
        ArrayList<Product> productArrayList = getListProductFull();
        ArrayList<Product> result=new ArrayList<>();
        for (int i = (index*size)-(size-1); i < (index*size); i++) {
            result.add(productArrayList.get(i));
        }
        return result;
    }
}
