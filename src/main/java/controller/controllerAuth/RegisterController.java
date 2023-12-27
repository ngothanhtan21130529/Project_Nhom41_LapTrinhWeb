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

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html,UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        String repeat = req.getParameter("repeat");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String phone = req.getParameter("phone");
        String policy = req.getParameter("policy");
        if (fullname != null
                && username != null
                && password != null
                && repeat != null && email
                != null
                && date != null
                && phone != null
                && policy != null) {
            UserDAO userDAO = UserDAO.getInstance();
            try {
                boolean auth = userDAO.insertUser(new User(username, password));
                if (auth) {
                    resp.getWriter().println("Thành công");
                } else {
                    resp.getWriter().println("Thất bai");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
