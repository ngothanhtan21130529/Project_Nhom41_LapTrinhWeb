package vn.edu.hcmuaf.controller.controllerAdmin.OrderDetailsCRUD;

import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.model.OrderDetail;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getInforOrderDetails")
public class UpdateOrderDetailStage1 extends HttpServlet {
    SearchService service = new SearchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String orderId = req.getParameter("id");
        int id = Integer.parseInt(orderId);
        OrderDetail orderDetailUpdate=service.getOrderDetailsByID(id);
        req.setAttribute("orderDetailUpdate", orderDetailUpdate);
        req.getRequestDispatcher("/views/admin/admin-order-details-update.jsp").forward(req, resp);
    }
}
