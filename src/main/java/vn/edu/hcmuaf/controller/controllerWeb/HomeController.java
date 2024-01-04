package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.CategoryService;

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

    public HomeController() throws SQLException {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Category> categories = categoryService.getAllCategories();

        req.setAttribute("categoryList", categories);


        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
