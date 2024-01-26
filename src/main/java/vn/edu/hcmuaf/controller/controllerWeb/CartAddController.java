package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Cart;
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

@WebServlet(name = "CartAddController", value = "/addproducts")
public class CartAddController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productImage = request.getParameter("img");
        String productName = request.getParameter("name");
        int productPrice = Integer.parseInt(request.getParameter("price"));
        HttpSession session = request.getSession();
        ProductService productService=new ProductService();
        if(session!=null){
            try {
                Product product=new Product(productService.getProductid(productName),productName,productPrice,productService.getProductImg(productName));
                CartService.addProduct(product);
                session.setAttribute("list", Cart.products);
                request.getRequestDispatcher("/views/web/cart/cart.jsp").forward(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}





