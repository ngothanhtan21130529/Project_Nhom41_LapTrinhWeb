package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.service.ForgotPasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatepassword")
public class UpdatePasswordForgotController extends HttpServlet {
    private ForgotPasswordService forgotPasswordService = new ForgotPasswordService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newpassword = req.getParameter("newpassword");
        String repeatpassword = req.getParameter("repeatpassword");

        if (newpassword.equals(repeatpassword)) {
            if (!email.equals("")) {
                try {
                    if (forgotPasswordService.updatePassword(newpassword, email)) {
                        req.setAttribute("notification", "Cập nhật mật khẩu thành công");
                        req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
                    } else {
                        req.setAttribute("notification", "Cập nhật mật khẩu thất bại vui lòng thử lại");
                        req.getRequestDispatcher("/views/login/updatepassword.jsp").forward(req, resp);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                req.setAttribute("notification", "Bạn phải nhập email ở trang quên mật khẩu trước");
                req.getRequestDispatcher("/views/login/updatepassword.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("notification", "Mật khâủ không trùng khớp");
            req.getRequestDispatcher("/views/login/updatepassword.jsp").forward(req, resp);
        }
    }
}
