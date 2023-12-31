package vn.edu.hcmuaf.controller.controllerAuth;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vn.edu.hcmuaf.service.ForgotPasswordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "ForgotPasswordController", value = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ForgotPasswordService forgotPasswordService = new ForgotPasswordService();
        try {
                final String HOST_NAME = "smtp.gmail.com";

                final int SSL_PORT = 465; // Port for SSL

                final int TSL_PORT = 587; // Port for TLS/STARTTLS

                final String APP_EMAIL = "ngoken102@gmail.com"; // your email

                final String APP_PASSWORD = "ywkx tiqu dqvh gjir"; // your password

                final String RECEIVE_EMAIL = "nttan101103@gmail.com";

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
                    try {
                        message.setSubject("Testing Subject");
                        message.setText("Welcome to gpcoder.com");
                        // send message
                        Transport.send(message);
                        resp.getWriter().println("ĐÃ TEST THÀNH CÔNG");
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }


                } catch (AddressException e) {
                    throw new RuntimeException(e);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}




















