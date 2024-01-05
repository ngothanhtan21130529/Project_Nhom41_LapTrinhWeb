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
                // Redirect to the home page or include its content here
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "products":
                // Redirect to the products page or include its content here
                request.getRequestDispatcher("views/web/category/products.jsp").forward(request, response);
                break;
            case "contact":
                // Redirect to the contact page or include its content here
                request.getRequestDispatcher("/contact.jsp").forward(request, response);
                break;
            case "policy":
                // Redirect to the policy page or include its content here
                request.getRequestDispatcher("/policy.jsp").forward(request, response);
                break;
            case "about":
                // Redirect to the about page or include its content here
                request.getRequestDispatcher("/about.jsp").forward(request, response);
                break;
            // Add more cases as needed
            default:
                // Handle the default case or redirect to an error page
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

