package controller.controllerAuth;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            insert(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void insert(HttpServletRequest request,HttpServletResponse respone) throws SQLException {
        String username=request.getParameter("username");
        String password=request.getParameter("pass");
        String pattern="^[a-zA-Z0-9]{6,20}$";
        UserDAO userDAO= UserDAO.getInstance();
        if(username.matches(pattern)){
            User user=new User(username,password,null);
            userDAO.insert(user);
        }else{

        }

    }
}
