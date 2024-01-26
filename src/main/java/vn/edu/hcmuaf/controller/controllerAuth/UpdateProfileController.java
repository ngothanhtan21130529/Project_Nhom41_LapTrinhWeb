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
import java.text.ParseException;

@WebServlet(name = "UpdateProfileController", value = "/updateprofile")
public class UpdateProfileController extends HttpServlet {
    private UpdateProfileService updateProfileService = new UpdateProfileService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String birthday = req.getParameter("birthday");
        HttpSession session = req.getSession();
        if (session != null) {
            if (session.getAttribute("username") != null) {
                //check phone number if phonenumber have 10 numbers and start with 0
                if (!phone.equals("")) {
                    if (phone.matches("^[0-9]{10}$")) {
                        try {
                            if (updateProfileService.updatePhone(phone, (String) session.getAttribute("username"))) {
                                req.setAttribute("notify", "Cập nhật thành công");
                                req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        resp.getWriter().println("Số điện thoại không hợp lệ");
                    }
                } else if (!birthday.equals("")) {
                    try {
                        if (updateProfileService.updateBirthday(birthday, (String) session.getAttribute("username"))) {
                            req.setAttribute("notify", "Cập nhật thành công");
                            req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("notify", "Cập nhật thất bại");
                            req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                } else if (!phone.equals("") && !birthday.equals("")) {
                    if (phone.matches("^[0-9]{10}$")) {
                        try {
                            if (updateProfileService.updatePhone(phone, (String) session.getAttribute("username"))) {
                                req.setAttribute("notify", "Cập nhật thành công");
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        resp.getWriter().println("Số điện thoại không hợp lệ");
                    }
                    try {
                        if (updateProfileService.updateBirthday(birthday, (String) session.getAttribute("username"))) {
                            req.setAttribute("notify", "Cập nhật thành công");
                            req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("notify", "Ngày sinh không hợp lệ");
                            req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                }
            } else {
//                resp.sendRedirect(req.getContextPath() + "/views/login/login.jsp");
                req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);
            }
        }
    }
}