package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> categories = CategoryDAO.getListCategory();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/web/category.jsp").forward(request, response);
    }

    protected  void  doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String categoryName = request.getParameter("category");
        response.sendRedirect(request.getContextPath() + "/category");
    }

}
