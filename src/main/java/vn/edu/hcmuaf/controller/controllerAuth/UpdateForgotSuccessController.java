package vn.edu.hcmuaf.controller.controllerAuth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatesuccess")
public class UpdateForgotSuccessController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect(req.getContextPath()+"/views/login/ìnformedforgotpassword.jsp");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login/informedforgotpassword.jsp");
        requestDispatcher.forward(req,resp);
    }
}
