package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.CartService;
import vn.edu.hcmuaf.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "CartRemoveController", value = "/removeproducts")
public class CartRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productImage = req.getParameter("img");
        String productName = req.getParameter("name");
        int productPrice = Integer.parseInt(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        ProductService productService = new ProductService();
        ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list");
        if (session != null) {
            try {
                Product product = new Product(productService.getProductid(productName), productName, productPrice, productService.getProductImg(productName));
                CartService.removeProduct(product);
                session.setAttribute("list", list);
                req.getRequestDispatcher("/web/cart.jsp").forward(req, resp);
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

}
}
