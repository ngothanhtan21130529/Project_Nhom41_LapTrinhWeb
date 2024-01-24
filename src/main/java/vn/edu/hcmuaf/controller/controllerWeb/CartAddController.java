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

@WebServlet(name = "CartAddController", value = "/addproducts")
public class CartAddController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productImage = request.getParameter("img");
        String productName = request.getParameter("name");
        int productPrice = Integer.parseInt(request.getParameter("price"));
        HttpSession session = request.getSession();
        if (session != null) {
            if (Cart.products.isEmpty()) {
                Cart.addProduct(new Product(productImage, productName, productPrice));
                session.setAttribute("list", Cart.products);
                response.sendRedirect(request.getContextPath() + "/views/header.jsp");
            } else {
                for (Product product : Cart.products) {
                    if (product.getImgURL().equalsIgnoreCase(productImage)) {
                        if (product.getProductName().equalsIgnoreCase(productName)) {
                            if (product.getPrice() == productPrice) {
                                request.setAttribute("message", "Sản phẩm đã có trong giỏ hàng");
                                request.getRequestDispatcher("/views/header.jsp").forward(request, response);
                            } else {
                                Cart.addProduct(new Product(productImage, productName, productPrice));
                                session.setAttribute("list", Cart.products);
                                response.sendRedirect(request.getContextPath() + "/views/header.jsp");
                            }

                        }
                    }
                }
            }
        }
    }
}
