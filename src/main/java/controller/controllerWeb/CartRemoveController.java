package controller.controllerWeb;

import model.Cart;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CartRemoveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String img=req.getParameter("img");
        String name=req.getParameter("name");
        int price=Integer.parseInt(req.getParameter("price"));
        Product product=new Product(img,name,price);
        HttpSession session= req.getSession();
        if(session!=null){
        ArrayList<Product> products=(ArrayList<Product>) session.getAttribute("list");
        for(int i=0;i<products.size();i++){
            if(products.get(i).equals(product)){
                products.remove(i);
                break;
            }
        }
            session.setAttribute("list", Cart.products);
            RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req,resp);
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
}