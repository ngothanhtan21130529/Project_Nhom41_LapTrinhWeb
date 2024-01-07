package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
//@WebServlet("/products")
//public class ProductController extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDAO productDAO = new ProductDAO();
//        ArrayList<Product> products = productDAO.getListProduct();
//        request.setAttribute("products", products);
//
//        request.getRequestDispatcher("jewelrys-list.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String productName = request.getParameter("products");
//    response.sendRedirect(request.getContextPath() + "/products");
//    }
//}

//@WebServlet("/products")
//public class ProductController extends HttpServlet {
//    private ProductDAO productDAO;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        try {
//            productDAO = new ProductDAO();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Product> products = productDAO.getListProduct();
//        request.setAttribute("products", products);
//
//        request.getRequestDispatcher("products.jsp").forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // Xử lý các yêu cầu POST nếu cần
//        response.sendRedirect(request.getContextPath() + "/products");
//    }
@WebServlet("/products")
public class ProductController extends HttpServlet {
    private ProductService productService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getListProducts();
        request.setAttribute("products", products);

        request.getRequestDispatcher("products.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Xử lý các yêu cầu POST nếu cần
        response.sendRedirect(request.getContextPath() + "/products");
    }
}
