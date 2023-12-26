package controller.controllerAuth;

import DAO.UserDAO;
import model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get values from form
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        boolean remember = Boolean.parseBoolean(req.getParameter("checkbox"));
        //create object userDAO
        UserDAO userDAO = UserDAO.getInstance();
        User user = null;
        try {
            user = userDAO.selectInformation(username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //admin role
        if (user.getRole().getRoleName().equals("Admin")) {
            HttpSession session = req.getSession();
            resp.sendRedirect("/web/admin.jsp");
            //user role
        } else if (user.getRole().getRoleName().equals("User")) {
            // set cookies
            if (remember) {
                Cookie account = new Cookie("username", username);
                Cookie password = new Cookie("password", pass);
                account.setMaxAge(12 * 24);
                password.setMaxAge(12 * 24);
                resp.addCookie(account);
                resp.addCookie(password);
                HttpSession httpSession = req.getSession();
//                resp.sendRedirect("/web/verify.jsp");
                //send otp to email
                final String HOST_NAME = "smtp.gmail.com";

                final int SSL_PORT = 465; // Port for SSL

                final int TSL_PORT = 587; // Port for TLS/STARTTLS

                final String APP_EMAIL = "ngoken102@gmail.com"; // your email

                final String APP_PASSWORD = "vowv pfvn kavl hvqq"; // your password

                final String RECEIVE_EMAIL = null;
                // Get properties object
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.host", HOST_NAME);
                props.put("mail.smtp.socketFactory.port", SSL_PORT);
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.port", SSL_PORT);

                // get Session
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
                    }
                });

                // compose message
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
                    message.setSubject("/web/verify.jsp");
                    message.setText("test");
                    // send message
                    Transport.send(message);

//                    resp.getWriter().println("ĐÃ TEST THÀNH CÔNG");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                HttpSession session = req.getSession();
//                resp.sendRedirect("/web/verify.jsp");
            }
            //if fail
        } else {
            HttpSession session = req.getSession();
            resp.getWriter().println("Đăng nhập thất bại");
        }

    }


    public static void main(String[] args) {


    }
}
