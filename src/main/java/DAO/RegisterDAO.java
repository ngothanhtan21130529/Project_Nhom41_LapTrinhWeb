package DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name="Register" ,value="/register")
public class RegisterDAO extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Connection connection=null;
        String name=req.getParameter("name");
        String user=req.getParameter("user");
        String pass=req.getParameter("pass");
        String repeat=req.getParameter("repeat");
        String email=req.getParameter("email");
        String date=req.getParameter("date");
        String phone=req.getParameter("phone");
        String policy=req.getParameter("policy");
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/gemstore";
            connection = DriverManager.getConnection(url,"root","");
            String sql="Insert into users(user_name,password) values('" + user + "','" + pass + "')";
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            resp.getWriter().println("thêm vào thành công");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}