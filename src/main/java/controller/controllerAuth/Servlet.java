package controller.controllerAuth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name="Servlet",value="/result")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        HttpSession session=req.getSession();
        if(session!=null){
        String res1=(String)    session.getAttribute("account");
        String res2=(String)    session.getAttribute("pass");
            resp.getWriter().println(res1+res2);
        }else{
            resp.getWriter().println("TEST THẤT BẠI");
        }

    }
}