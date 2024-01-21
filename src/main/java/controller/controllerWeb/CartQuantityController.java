package controller.controllerWeb;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CartQuantityController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quantity=Integer.parseInt(req.getParameter("quantity"));
        String name=req.getParameter("name");
        String img=req.getParameter("image");
        int price=Integer.parseInt(req.getParameter("price"));
        Product product=new Product(img,name,price);
        HttpSession session= req.getSession();
        int res=0;
        if(session!=null){
            ArrayList<Product> list=(ArrayList<Product>)session.getAttribute("list");
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals(product)){
                      res=list.get(i).getPrice()*quantity;
                }
                break;
            }
            session.setAttribute("list",list);
            session.setAttribute("price",res);
            RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("cart.jsp");
            requestDispatcher.forward(req,resp);
        }else{
            resp.sendRedirect("index.jsp");
        }


    }
}