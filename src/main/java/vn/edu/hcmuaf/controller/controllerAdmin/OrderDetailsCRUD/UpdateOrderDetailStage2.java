package vn.edu.hcmuaf.controller.controllerAdmin.OrderDetailsCRUD;

import vn.edu.hcmuaf.service.AddingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateOrderDetails")
public class UpdateOrderDetailStage2 extends HttpServlet {
    AddingService addingService=new AddingService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order_detail_id=req.getParameter("order_detail_id");
        int id=Integer.parseInt(order_detail_id);
        String status=req.getParameter("order_details_status");
        addingService.updateStatusOrderDetails(id, status);
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}
