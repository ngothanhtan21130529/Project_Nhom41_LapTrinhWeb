package controller.controllerWeb;

import connection.MySqlConnection;

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
        try {
            insertDB(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void insertDB(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Connection mySqlConnection = MySqlConnection.getConnection();
        String sql = "INSERT INTO feedbacks(full_name,email,phone,title,feedback_content)VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = mySqlConnection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, title);
        preparedStatement.setString(5, content);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("./web/contact.jsp");
            request.setAttribute("announce","Đã thêm thành công");
            requestDispatcher.include(request,response);
        }else{
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("./web/contact.jsp");
            request.setAttribute("announce","Chưa thành công");
            requestDispatcher.include(request,response);
        }
    }
}