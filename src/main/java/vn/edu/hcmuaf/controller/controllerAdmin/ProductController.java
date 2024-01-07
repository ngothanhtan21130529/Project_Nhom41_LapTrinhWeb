package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductService productService = new ProductService();

    public ProductController() throws SQLException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getListProducts();
        request.setAttribute("productList", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/category/products.jsp");
        dispatcher.forward(request, response);
    }
}

