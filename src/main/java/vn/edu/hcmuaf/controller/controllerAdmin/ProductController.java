package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/products")
public class ProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDAO productDAO = new ProductDAO();
////        ArrayList<Product> products = productDAO.getListProduct();
//        request.setAttribute("products", products);
//
//        request.getRequestDispatcher("jewelrys-list.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String productName = request.getParameter("product");
//    response.sendRedirect(request.getContextPath() + "/product");
//    }
    }
}
