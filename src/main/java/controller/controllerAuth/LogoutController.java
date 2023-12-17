package controller.controllerAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        HttpSession session=req.getSession();
        if(session!=null){
            session.invalidate();
            resp.sendRedirect("");
        }else{
            resp.sendRedirect("");
        }
    }
}
