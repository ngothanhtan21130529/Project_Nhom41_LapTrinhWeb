package controller.controllerAuth;
import connection.MySqlConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("username");
        String oldpass = req.getParameter("oldpass");
        String newpass = req.getParameter("newpass");
        String repeat = req.getParameter("repeat");
        if ((!oldpass.equalsIgnoreCase(newpass)) && (newpass.equalsIgnoreCase(repeat))) {
            try {
                Connection c = MySqlConnection.getConnection();
                String sql = "UPDATE TABLE users SET password=? WHERE username=? ";

                PreparedStatement preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, newpass);
                preparedStatement.setString(2, name);
                int i = preparedStatement.executeUpdate();
                if (i > 0) {
                    req.setAttribute("announce", "Cập nhật thành công");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("./web/change-password.jsp");
                    requestDispatcher.include(req, resp);
                } else {
                    req.setAttribute("annouce", "Mật khẩu không khớp");
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("./web/change-password.jsp");
                    requestDispatcher.include(req, resp);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}