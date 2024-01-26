package vn.edu.hcmuaf.controller.controllerAuth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "VerifyRegisterController", value = "/verifyregister")
public class VerifyRegisterController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session != null) {
//            resp.sendRedirect(req.getContextPath()+"/views/login/informedregister.jsp");
            req.getRequestDispatcher("/views/login/informedregister.jsp").forward(req, resp);
        }
    }
}
