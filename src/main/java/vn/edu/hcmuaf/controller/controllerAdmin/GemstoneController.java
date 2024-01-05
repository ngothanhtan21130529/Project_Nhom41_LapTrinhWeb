package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gemstone")
public class GemstoneController extends HttpServlet {
    private CategoryService categoryService;

    public GemstoneController() throws SQLException {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> categories = categoryService.getAllCategories();

        req.setAttribute("categoryList", categories);

        req.getRequestDispatcher("/views/web/category/gemstone.jsp").forward(req, resp);
    }
}
