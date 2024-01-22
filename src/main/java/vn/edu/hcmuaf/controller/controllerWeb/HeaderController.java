package vn.edu.hcmuaf.controller.controllerWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/headerController")
public class HeaderController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "home":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "products":
                request.getRequestDispatcher("views/web/category/products.jsp").forward(request, response);
                break;
            case "jewelrys":
                request.getRequestDispatcher("views/web/category/jewelrys.jsp").forward(request, response);
            case "contact":
                request.getRequestDispatcher("/contact.jsp").forward(request, response);
                break;
            case "policy":
                request.getRequestDispatcher("/policy.jsp").forward(request, response);
                break;
            case "about":
                request.getRequestDispatcher("/about.jsp").forward(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

