package vn.edu.hcmuaf.controller.controllerAuth;

import jakarta.mail.internet.AddressException;
import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkLogin(req, resp);
        } catch (SQLException | AddressException e) {
            throw new RuntimeException(e);
        }
    }

    protected void checkLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, AddressException {
        LoginService loginService = new LoginService();
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        ArrayList<User> list = loginService.getAllUser();
        HttpSession session = request.getSession();
        if (username == null || pass == null) {
            request.setAttribute("notify", "Vui lòng nhập đầy đủ thông tin");
            request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
        } else {
            boolean isvalid = false;
            User user = null;
            for (User u : list) {
                if (u.getUserName().equals(username) && u.getPassword().equals(pass)) {
                    isvalid = true;
                    user = u;
                    break;
                }
            }
            if (isvalid) {
                if (session != null) {
                    if (user.getRole().getRoleName().equals("Admin")) {
                        session.setAttribute("username", username);
                        request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
                    } else if (user.getRole().getRoleName().equals("User")) {
                        session.setAttribute("username", username);
                        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("notify", "Tài khoản hoặc mật khẩu không tồn tại");
                request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
            }

        }

    }

}
