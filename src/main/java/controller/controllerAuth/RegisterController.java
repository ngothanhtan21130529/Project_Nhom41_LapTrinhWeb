package controller.controllerAuth;

import DAO.UserDAO;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        String repeat = req.getParameter("repeat");
        String email = req.getParameter("email");
        String date = req.getParameter("date");
        String phone = req.getParameter("phone");
        String policy = req.getParameter("policy");
        if (fullname != null
                && username != null
                && password != null
                && repeat != null && email
                != null
                && date != null
                && phone != null
                && policy != null) {
            UserDAO userDAO = UserDAO.getInstance();
            try {
                boolean auth = userDAO.insertUser(new User(username, password));
                if (auth) {
                    sendEmail();
                    resp.getWriter().println("Thành công");
                } else {
                    resp.getWriter().println("Thất bai");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

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
            String link = "<a href=\"http://localhost:8080/Project_Nhom_41_war/verifyregister\">Xác nhận đăng ký</a>";
            message.setContent(link, "text/html;charset=utf-8");
            // send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
    }
}
