package vn.edu.hcmuaf.controller.controllerAuth;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
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
import java.util.Properties;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

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
        HttpSession session=request.getSession();
        if (username.equals("")|| pass.equals("")) {
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
                        sendEmailForAdmin(request, response, username);
                        session.setAttribute("username", username);
                        request.setAttribute("notify","Đăng nhập thành công vui lòng kiểm tra email");
                        request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
                    } else if (user.getRole().getRoleName().equals("User")) {
                        sendEmailForUser(request, response, username);
                        session.setAttribute("username", username);
                        request.setAttribute("notify","Đăng nhập thành công vui lòng kiểm tra email");
                        request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
                    }
                }
            } else {
                request.setAttribute("notify", "Tài khoản hoặc mật khẩu không tồn tại");
                request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
            }

        }

    }

    protected void sendEmailForUser(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String username) {
        LoginService loginService = new LoginService();
        try {
            final String HOST_NAME = "smtp.gmail.com";
            final int SSL_PORT = 465; // Port for SSL
            final String APP_EMAIL = "ngoken102@gmail.com"; // your email
            final String APP_PASSWORD = "hfef chqv lick rcfx"; // your password
            final String RECEIVE_EMAIL = loginService.getEmail(username);

            // Get properties object
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", HOST_NAME);
            props.put("mail.smtp.socketFactory.port", SSL_PORT);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.port", SSL_PORT);

            // get Session
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
                }
            });

            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
                message.setSubject("Chúc mừng bạn đã đăng nhập thành công");
                String url="<a href=\"http://localhost:8080/Project_Nhom_41_war/verifylogin/user\">Click vào đây để xác nhận</a>";
                message.setContent("<h1>Chúc mừng bạn đã đăng nhập thành công</h1>"+url, "text/html;charset=UTF-8");

                // send message
                Transport.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void sendEmailForAdmin(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String username) {
        LoginService loginService = new LoginService();
        try {
            final String HOST_NAME = "smtp.gmail.com";
            final int SSL_PORT = 465; // Port for SSL
            final String APP_EMAIL = "ngoken102@gmail.com"; // your email
            final String APP_PASSWORD = "hfef chqv lick rcfx"; // your password
            final String RECEIVE_EMAIL = loginService.getEmail(username);

            // Get properties object
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", HOST_NAME);
            props.put("mail.smtp.socketFactory.port", SSL_PORT);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.port", SSL_PORT);

            // get Session
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
                }
            });

            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
                message.setSubject("Chúc mừng bạn đã đăng nhập thành công");
                String url="<a href=\"http://localhost:8080/Project_Nhom_41_war/verifylogin/admin\">Click vào đây để xác nhận</a>";
                message.setContent("<h1>Chúc mừng bạn đã đăng nhập thành công</h1>"+url, "text/html;charset=UTF-8");

                // send message
                Transport.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}