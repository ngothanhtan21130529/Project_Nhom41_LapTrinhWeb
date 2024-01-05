package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.service.UpdateProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdatePhoneController", value = "/updatephone")
public class UpdatePhoneController extends HttpServlet {
    private UpdateProfileService updateProfileService = new UpdateProfileService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession();
        if (session != null) {
            if (session.getAttribute("username") != null) {
                if (phone.matches("^[0-9]{10}$")) {
                    try {
                        if (updateProfileService.updatePhone(phone, (String) session.getAttribute("username"))) {
                            req.setAttribute("notify", "Cập nhật thành công");
                            req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/views/login/login.jsp");
        }
    }
}