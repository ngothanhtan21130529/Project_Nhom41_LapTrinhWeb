package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.CategoryService;
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

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private CategoryService categoryService;
    private ProductService productService;

    public HomeController() throws SQLException {
        categoryService = new CategoryService();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Category> categories = categoryService.getAllCategories();
        ArrayList<Product> products = productService.getListProducts();
        ArrayList<Product> jewelryList = productService.getJewelryList();

        req.setAttribute("categoryList", categories);
        req.setAttribute("productList", products);
        req.setAttribute("jewelryList", jewelryList);


        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
