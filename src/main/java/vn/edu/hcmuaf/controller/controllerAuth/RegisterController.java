package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterService registerService = new RegisterService();
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        String repeat = req.getParameter("repeat");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String phone = req.getParameter("phone");
        String policy = req.getParameter("policy");
        String regexfullname = "^[\\p{L}\\s']*\\p{L}+$";
        String regexusername = "^[a-zA-Z0-9]{5,15}$";
        String regexpassword = "^(?=.*[a-zA-Z])(?=.*\\d).{5,15}$";
        String regexemail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        //trường hợp 1 tất cả thông tin không được nhập
        if (fullname == null && username == null && password == null && repeat == null && email == null && date == null && phone == null && policy == null) {
            HttpSession session = req.getSession();
            if (session != null) {
                session.setAttribute("announced", "Không được để trống dữ liệu");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            } else {
                session = req.getSession(true);
                session.setAttribute("announced", "Không được để trống dữ liệu");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            }

            //trường hợp 2 một hoặc nhiều thông tin để trống

        } else if ((fullname == null || username == null || password == null || repeat == null || email == null || date == null || phone == null || policy == null)) {
            HttpSession session = req.getSession();
            if (session != null) {
                session.setAttribute("announced", "Không được để trống dữ liệu");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            } else {
                session = req.getSession(true);
                session.setAttribute("announced", "Không được để trống dữ liệu");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            }
            //trường hợp 3 điền tất cả thông tin nhưng chưa tích chọn
        } else if ((fullname != null && username != null && password != null && repeat != null && email != null && date != null && phone != null && policy == null)) {
            HttpSession session = req.getSession();
            if (session != null) {
                session.setAttribute("announced", "Bạn phải tích chọn để xác nhận");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            } else {
                session = req.getSession(true);
                session.setAttribute("announced", "Bạn phải tích chọn để xác nhận");
                resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
            }
            // trường hợp 4 điền và tích chọn nhưng vẫn để trống 1 vài thông tin

        } else if ((fullname != null || username != null || password != null || repeat != null || email != null || date != null || phone != null) && policy != null) {
            {
                HttpSession session = req.getSession();
                if (session != null) {
                    session.setAttribute("announced", "Bạn không được để trống thông tin");
                    resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
                } else {
                    session = req.getSession(true);
                    session.setAttribute("announced", "Bạn không được để trống thông tin ");
                    resp.sendRedirect(req.getContextPath() + "/views/login/register.jsp");
                }
            }
        }
    }
}



