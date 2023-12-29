package vn.edu.hcmuaf.controller.controllerAdmin;

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

@WebServlet("/categories")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService;

    public CategoryController() throws SQLException {
        categoryService = new CategoryService();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            this.categoryService = new CategoryService();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = categoryService.getAllCategories();
//        System.out.println("------------" + categories.size());

        request.setAttribute("categoryList", categories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/category/category.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
