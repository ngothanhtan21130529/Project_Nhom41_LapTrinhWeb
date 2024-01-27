package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/headerController")
public class HeaderController extends HttpServlet {
    private CategoryService categoryService;

    public HeaderController() throws SQLException {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryService = new CategoryService(categoryDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "home":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "all-products":
                request.getRequestDispatcher("/views/web/category/all-products.jsp").forward(request, response);
                break;
            case "jewelry":
                request.getRequestDispatcher("/views/web/category/jewelrys.jsp").forward(request, response);
                break;
            case "contact":
                request.getRequestDispatcher("/contact.jsp").forward(request, response);
                break;
            case "policy":
                request.getRequestDispatcher("/policy.jsp").forward(request, response);
                break;
            case "about":
                request.getRequestDispatcher("/about.jsp").forward(request, response);
                break;
            case "gemstone":
                // Fetch gemstone categories and set them as a request attribute
                List<Category> gemstoneCategories = null;
                try {
                    gemstoneCategories = categoryService.getAllGemCategories();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("gemstoneCategories", gemstoneCategories);

                // Forward the request to gemstone.jsp
                request.getRequestDispatcher("/views/web/category/gemstone.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
