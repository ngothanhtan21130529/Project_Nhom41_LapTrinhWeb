package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Order;
import vn.edu.hcmuaf.service.OrderManageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//this page for manage orders
@WebServlet("/ordermanage")
public class OrderManageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderManageService orderManageService = new OrderManageService();
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        try {
            orderManageService.getListOrderDetails();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter=resp.getWriter();
//        printWriter.print();
    }
}
