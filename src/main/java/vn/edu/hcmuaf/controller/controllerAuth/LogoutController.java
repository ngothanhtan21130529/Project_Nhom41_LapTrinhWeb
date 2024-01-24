package vn.edu.hcmuaf.controller.controllerAuth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="LogoutController",value="/Logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(session!=null){
            session.invalidate();
            resp.sendRedirect(req.getContextPath()+"/views/login/login.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/views/login/login.jsp");
        }
    }
}
