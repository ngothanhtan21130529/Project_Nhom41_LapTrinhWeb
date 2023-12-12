package controller.controllerWeb;

import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        List<Product> productList = (ArrayList) session.getAttribute("list");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals("name"))
                productList.remove(productList.get(i));
            break;
        }
    }
}
