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
import java.util.List;

@WebServlet("/getOderDetails")
public class OrderDetailsShowing extends HttpServlet {
    SearchService service = new SearchService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String orderID = request.getParameter("id");
        int id = Integer.parseInt(orderID);
        ArrayList<OrderDetail> orderArrayList = service.GetOrderDetailsListByID(id);
        request.setAttribute("orderDetailArrayList", orderArrayList);
        request.getRequestDispatcher("/views/admin/admin-order-details.jsp").forward(request, response);
    }
}
