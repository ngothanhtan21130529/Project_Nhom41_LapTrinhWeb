package controller.controllerWeb;

import model.Cart;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String img = request.getParameter("img");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product=new Product(img,name,price);
        HttpSession session = request.getSession();
        if (session != null) {
            for(int i=0;i<Cart.products.size();i++){
                if(Cart.products.size()==0){
                    Cart.addProduct(product);
                    break;
                }else if(Cart.products.get(i).equals(product)){
                    Cart.addProduct(product);
                    break;
                }

            }

            session.setAttribute("list",Cart.products);
            RequestDispatcher requestDispatcher = session.getServletContext().getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
