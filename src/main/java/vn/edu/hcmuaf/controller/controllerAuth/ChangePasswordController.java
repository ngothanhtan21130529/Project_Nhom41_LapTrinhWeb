package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.service.ChangePasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ChangePasswordController", value = "/changepassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        String currentpassword = req.getParameter("currentpassword");
        String newpassword = req.getParameter("newpassword");
        String repeatpassword = req.getParameter("repeatpassword");
        HttpSession session = req.getSession();
        if (session != null) {
            String username = (String) session.getAttribute("username");
            if (!currentpassword.equals(newpassword) && newpassword.equals(repeatpassword)) {
                try {
                    if (changePasswordService.updatePassword(username, newpassword)) {
                        resp.sendRedirect(req.getContextPath()+"/views/login/informedchangepassword.jsp");
                    }else{
                        resp.sendRedirect(req.getContextPath()+"/views/login/changepassword.jsp");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                session.setAttribute("notify","Mật khẩu phải trùng khớp với nhau");
                resp.sendRedirect(req.getContextPath()+"/views/login/changepassword.jsp");
            }

        }else{
            session= req.getSession(true);
            resp.sendRedirect(req.getContextPath()+"/views/login/changepassword.jsp");
        }
    }
}
