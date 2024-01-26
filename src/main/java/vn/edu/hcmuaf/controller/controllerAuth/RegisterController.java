package vn.edu.hcmuaf.controller.controllerAuth;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vn.edu.hcmuaf.model.Role;
import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.LoginService;
import vn.edu.hcmuaf.service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private RegisterService registerService = new RegisterService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String repeat = request.getParameter("repeat");
        String email = request.getParameter("email");
        String policy = request.getParameter("policy");

        //regex
        String passwordRegex = "^.{3,15}$";
        String usernameRegex = "^[a-zA-Z0-9]{2,10}$";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,5}$";
        try {
            checkRegister(request, response, username, password, repeat, email, policy, passwordRegex, usernameRegex, emailRegex, registerService);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendEmail(HttpServletRequest request, HttpServletResponse response, String username, RegisterService registerService) {
        try {
            final String HOST_NAME = "smtp.gmail.com";
            final int SSL_PORT = 465; // Port for SSL
            final String APP_EMAIL = "ngoken102@gmail.com"; // your email
            final String APP_PASSWORD = "hfef chqv lick rcfx"; // your password
            final String RECEIVE_EMAIL = registerService.getEmailforAuth(username);

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
                String url="<a href=\"http://localhost:8080/Project_Nhom_41_war/verifyregister\">Click vào đây để xác nhận</a>";

                message.setSubject("Chúc mừng! Bạn đã đăng ký thành công");
                message.setContent("<h1>Chúc mừng! Bạn đã đăng ký thành công</h1>"+url, "text/html;charset=utf-8");

                // send message
                Transport.send(message);

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void checkRegister(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String username, String password, String repeat, String email, String policy, String passwordRegex, String usernameRegex, String emailRegex, RegisterService registerService) throws ServletException, IOException {
        // Case 1: All fields are empty
        if (username.equals("") && password.equals("") && repeat.equals("") && email.equals("") && policy == null) {
            servletRequest.setAttribute("announced", "Lam on dien tat ca cac truong thong tin");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);
            // Case 2: Two or more fields are empty
        } else if (username.equals("") || password.equals("") || repeat.equals("") || email.equals("") || policy == null) {
            servletRequest.setAttribute("announced", "Mot hoac nhieu truong thong tin chua duoc dien");
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
            requestDispatcher.forward(servletRequest, servletResponse);
            // Case 3: All fields are filled out
        } else if (!username.equals("") && !password.equals("") && !repeat.equals("") && !email.equals("") && policy != null) {
            int invalid = 0;
            if (!username.matches(usernameRegex)) {
                invalid++;
            }
            if (!password.matches(passwordRegex)) {
                invalid++;
            }
            if (!password.equals(repeat)) {
                invalid++;
            }
            if (!email.matches(emailRegex)) {
                invalid++;
            }
            if (invalid >= 2) {
                servletRequest.setAttribute("announced", "Nhiều trường không hợp lệ");
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
                requestDispatcher.forward(servletRequest, servletResponse);
            } else if (invalid == 1) {
                servletRequest.setAttribute("announced", "Một trường không hợp lệ");
                RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
                requestDispatcher.forward(servletRequest, servletResponse);
            } else {
                try {
                    if (registerService.checkDuplicatedUsername(username) || registerService.checkDuplicatedEmail(email)) {
                        servletRequest.setAttribute("announced", "Tài khoản hoặc mật khẩu đã tồn tại");
                        RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
                        requestDispatcher.forward(servletRequest, servletResponse);
                    } else {
                        User user = new User(registerService.getMaxID(), username, password, email, new Role(2));
                        if (registerService.insertUser(user)) {
                            sendEmail(servletRequest, servletResponse, username, registerService);
                            servletRequest.setAttribute("announced", "Đăng nhập thành công vui lòng kiểm tra email để xác nhận");
                            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
                            requestDispatcher.forward(servletRequest, servletResponse);
                        } else {
                            servletRequest.setAttribute("announced", "Đăng nhập thất bại");
                            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/views/login/register.jsp");
                            requestDispatcher.forward(servletRequest, servletResponse);
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}