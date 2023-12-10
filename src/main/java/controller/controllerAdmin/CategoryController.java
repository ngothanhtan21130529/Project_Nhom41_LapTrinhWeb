package controller.controllerAdmin;

//import DAO.CategoryDAO;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        CategoryDAO categoryDAO = new CategoryDAO();
//        ArrayList<Category> categories = categoryDAO.getListCategory();
//        request.setAttribute("categories",categories);
//        request.getRequestDispatcher("category.jsp").forward(request, response);
//    }
}
