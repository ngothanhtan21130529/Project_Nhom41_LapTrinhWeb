package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.OrderDAO;
import vn.edu.hcmuaf.service.OrderManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//this page for manage orders
@WebServlet("/ordermanage")
public class OrderManageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderManageService orderManageService = new OrderManageService();
        HttpSession session = req.getSession();
        try {
            orderManageService.getListOrders(OrderDAO.getInstance());
            if (session != null) {
                if (session.getAttribute("username") != null) {
                    session.setAttribute("listorderdetails", orderManageService.getListOrders(OrderDAO.getInstance()));
                    req.getRequestDispatcher("/views/admin/ordermanage.jsp").forward(req, resp);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
