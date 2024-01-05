package vn.edu.hcmuaf.controller.controllerWeb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="OrderSuccessController",value="/ordersuccess")
public class OrderSuccessController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null) {
            if (session.getAttribute("username") != null) {
                resp.sendRedirect(req.getContextPath() + "/views/order/orderSuccess.jsp");
            } else {
                resp.sendRedirect(req.getContextPath() + "/views/login/login.jsp");
            }
        }
    }
}
