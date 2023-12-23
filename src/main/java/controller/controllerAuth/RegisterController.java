package controller.controllerAuth;

import DAO.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(name="RegisterController",value="/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            insert(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void insert(HttpServletRequest request,HttpServletResponse respone) throws SQLException, ServletException, IOException {
        String fullname=request.getParameter("fullname");
        String username=request.getParameter("user");
        String password=request.getParameter("pass");
        String repeat=request.getParameter("repeat");
        String email=request.getParameter("email");
        String date=request.getParameter("date");
        String phone=request.getParameter("phone");
        String policy=request.getParameter("policy");
        String pattern="^[a-zA-Z0-9]{6,20}$";
       if(username.matches(pattern)){
           HttpSession session=request.getSession();
           RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("/login/register.jsp");
           session.setAttribute("announce","Successful");
           requestDispatcher.forward(request,respone);
       }else{
           HttpSession session=request.getSession();
           RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("/login/register.jsp");
           session.setAttribute("announce","Failed");
           requestDispatcher.forward(request,respone);
       }


    }
}
