package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkLogin(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        LoginService loginService = new LoginService();
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        User user = loginService.getUser(username, pass);
        if (user == null || pass == null) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.setAttribute("informed", "Tài khoản hoặc mật khẩu không được để trống");
                response.sendRedirect(request.getContextPath() + "/views/login/login.jsp");
            } else {
                session = request.getSession(true);
                session.setAttribute("informed", "Tài khoản hoặc mật khẩu không được để trống");
                response.sendRedirect(request.getContextPath() + "/views/login/login.jsp");
            }
        } else if (user == null && pass == null) {
            if (user == null || pass == null) {
                HttpSession session = request.getSession();
                if (session != null) {
                    session.setAttribute("informed", "Tài khoản hoặc mật khẩu không được để trống");
                    response.sendRedirect(request.getContextPath() + "view/login/login.jsp");
                } else {
                    session = request.getSession(true);
                    session.setAttribute("informed", "Tài khoản hoặc mật khẩu không được để trống");
                    response.sendRedirect(request.getContextPath() + "view/login/login.jsp");
                }

            }

        } else if (user.getUserName().equals(username) && user.getPassword().equals(pass)) {
            if (user.getRole().getRoleName().equals("Admin")) {
                HttpSession session = request.getSession();
                if (session != null) {
                    session.setAttribute("username", user.getUserName());
                    response.sendRedirect(request.getContextPath() + "views/admin/admin.jsp");
                }

            } else if (user.getRole().getRoleName().equals("User")) {
                HttpSession session = request.getSession();
                if (session != null) {
                    session.setAttribute("username", user.getUserName());
                    response.sendRedirect(request.getContextPath() + "views/index.jsp");
                }

            }
        }
    }
}
