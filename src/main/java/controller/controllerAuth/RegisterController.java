package controller.controllerAuth;

import DAO.UserDAO;
import connection.MySqlConnection;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(name="RegisterController",value="/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String fullname=req.getParameter("fullname");
        String username=req.getParameter("user");
        String password=req.getParameter("pass");
        String repeat=req.getParameter("repeat");
        String email=req.getParameter("email");
        String date=req.getParameter("date");
        String phone=req.getParameter("phone");
        String policy=req.getParameter("policy");
//        String pattern="^[a-zA-Z0-9]{6,20}$";
        UserDAO userDAO=UserDAO.getInstance();
        User user=new User(username,password);
        try {
            userDAO.insertUser(user);
            if(userDAO.insertUser(user)){
                resp.getWriter().println("Thanh cong");
            }else{
                resp.getWriter().println("That Bai");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
