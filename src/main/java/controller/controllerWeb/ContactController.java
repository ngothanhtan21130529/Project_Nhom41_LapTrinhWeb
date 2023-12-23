package controller.controllerWeb;

import connection.MySqlConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        try {
            Connection mySqlConnection = MySqlConnection.getConnection();
            String sql = "INSERT INTO feedbacks(full_name,email,phone,title,feedback_content)VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = mySqlConnection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, title);
            preparedStatement.setString(5, content);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                RequestDispatcher reqDispatcher= req.getRequestDispatcher("./web/contact.jsp");
                req.setAttribute("announce","Đã thêm thành công");
                reqDispatcher.include(req,resp);
            }else{
                RequestDispatcher reqDispatcher= req.getRequestDispatcher("./web/contact.jsp");
                req.setAttribute("announce","Chưa thành công");
                reqDispatcher.include(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

     
    }
