package controller.controllerWeb;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController {
    List<Product> list = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String image = request.getParameter("image");
        Product product = new Product(name, price, image);
        list.add(product);
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        RequestDispatcher requestDispatcher = session.getServletContext().getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request,response);
    }
}
