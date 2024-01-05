package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartRemoveController", value = "/removeproducts")
public class CartRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        int price = Integer.parseInt(req.getParameter("price"));
        Product product = new Product(img, name, price);
        HttpSession session=req.getSession();
        if(session!=null){
            ArrayList<Product> list=(ArrayList<Product>) session.getAttribute("list");
            if(list!=null){
                if(list.contains(product)){
                    list.remove(product);
                    session.setAttribute("list",list);
                    resp.sendRedirect(req.getContextPath()+"/views/web/cart/cart.jsp");
                }
            }

        }

    }
}
