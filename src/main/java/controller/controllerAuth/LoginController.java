package controller.controllerAuth;

import DAO.UserDAO;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            checkLogin(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

    protected void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException, MessagingException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("checkbox");
        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.selectInformation(username, password);
        if (username == null && password == null) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.setAttribute("announce", "Tài khoản mật khẩu không được để trống");
                RequestDispatcher requestDispatcher = session.getServletContext().getRequestDispatcher(request.getContextPath() + "/login/login.jsp");
                requestDispatcher.forward(request, response);
            }
        } else if (username.equals(user.getUserName()) && password.equals(user.getPassword())
                && user.getRole().getRoleName().equals("Admin")) {
            HttpSession session = request.getSession();
            if (session != null) {
                response.sendRedirect(request.getContextPath() + "/web/admin.jsp");
            }


        } else if (username.equals(user.getUserName()) && password.equals(user.getPassword()) &&
                user.getRole().getRoleName().equals("User")) {
            if (checkbox != null) {
                setCookies(request, response, username, password);
            }
            HttpSession session = request.getSession();
            if (session != null) {
                session.setAttribute("name", username);
                sendEmail();
            }
        }


    }


    protected void setCookies(HttpServletRequest servletRequest, HttpServletResponse servletResponse, String username, String password) {
        Cookie useraccount = new Cookie("username", username);
        Cookie pass = new Cookie("pass", password);
        useraccount.setMaxAge(24 * 24);
        pass.setMaxAge(24 * 24);
        servletResponse.addCookie(useraccount);
        servletResponse.addCookie(pass);
    }

    protected void sendEmail() {
        final String HOST_NAME = "smtp.gmail.com";

        final int SSL_PORT = 465; // Port for SSL

        final int TSL_PORT = 587; // Port for TLS/STARTTLS

        final String APP_EMAIL = "ngoken102@gmail.com"; // your email

        final String APP_PASSWORD = "vowv pfvn kavl hvqq"; // your password
//them 1 buoc truy van la lay ra email cua tai khoan moi vua dang nhap
        final String RECEIVE_EMAIL = "ngoken102@gmail.com";
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.socketFactory.port", SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", SSL_PORT);

        // get Session
        Session mail_session = Session.getDefaultInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
            }
        });

        // compose message
        try {
            MimeMessage message = new MimeMessage(mail_session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
            message.setSubject("Xác thực email");
            String link = "<a href=\"http://localhost:8080/Project_Nhom_41_war/verify\">Xác nhận đăng nhập</a>";
            message.setContent(link, "text/html;charset=utf-8");
            // send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}




