package controllerWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/login")
public class myServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      super.doPost(req, resp);

        Connection connection = null;
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/gemstore";
            connection = DriverManager.getConnection(url, "root", "");
            resp.getWriter().println("Kết nối thành công");

            String sql = "SELECT username, password FROM users WHERE username = '" + username + "' AND password = '" + pass + "'";
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            String user = null;
            String password = null;
            while (resultSet.next()) {
                user = resultSet.getString(2);
                password = resultSet.getString(3);
            }
            resultSet.close();
            if (username.equals(user) && pass.equals(password)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(req, resp);
            }
//'            System.out.println("Kết nối thành công");'
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
