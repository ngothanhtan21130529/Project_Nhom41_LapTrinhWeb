package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.PrintService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminDisplayment", value = "/admin")
public class AdminDisplayment extends HttpServlet {
    PrintService printService = new PrintService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArrayList<Category> categoryArrayList = printService.getListCategoryFull();
            ArrayList<Product> productArrayList = printService.getListProductFull();
            ArrayList<Order> orderArrayList=printService.getListDistinctOrderFull();
            ArrayList<User> userArrayList = printService.getListUserFull();
            request.setAttribute("categoryArrayList", categoryArrayList);
            request.setAttribute("productArrayList", productArrayList);
            request.setAttribute("orderArrayList", orderArrayList);
            request.setAttribute("userArrayList", userArrayList);
            request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
