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
import java.util.HashMap;
import java.util.Map;

@WebServlet(value="/orderdetails")
public class OrderDetailsController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        ArrayList<Product> products=(ArrayList<Product>) session.getAttribute("list");
        String[] quantity= req.getParameterValues("quantity");
        Map<String,Product> orders=new HashMap<String, Product>();
        for(int i=0;i< products.size();i++){
            for(int j=0;j< quantity.length;j++){
                if(j==i){
                    orders.put(quantity[i],products.get(i));
                    break;
                }
            }
        }
        int totalprice=0;
        if(session!=null){
            for(int i=0;i<products.size();i++){
                totalprice=totalprice+(products.get(i).getPrice()*Integer.parseInt(quantity[i]));
            }
        }

    }
}
