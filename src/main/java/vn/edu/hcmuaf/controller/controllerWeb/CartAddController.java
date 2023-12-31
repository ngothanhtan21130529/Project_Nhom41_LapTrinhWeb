package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Cart;
import vn.edu.hcmuaf.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="CartAddController",value="/addproducts")
public class CartAddController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productImage=request.getParameter("img");
        String productName=request.getParameter("name");
        int productPrice=Integer.parseInt(request.getParameter("price"));
        Product product=new Product(productImage,productName,productPrice);
        HttpSession session=request.getSession();
        if(session!=null){
            if(!Cart.products.contains(product)){
                Cart.products.add(product);
                session.setAttribute("list",Cart.products);
            }
        }


    }
}
