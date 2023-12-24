package controller.controllerAuth;

import DAO.UserDAO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ForgotPasswordController", value = "/forgot")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String email = req.getParameter("email");
        UserDAO userDAO = UserDAO.getInstance();
        try {
            String mail = userDAO.getEmail(email);
          if(email.equals(mail)){
              final String HOST_NAME = "smtp.gmail.com";

              final int SSL_PORT = 465; // Port for SSL

              final int TSL_PORT = 587; // Port for TLS/STARTTLS

              final String APP_EMAIL = "ngoken102@gmail.com"; // your email

              final String APP_PASSWORD = "vowv pfvn kavl hvqq"; // your password

              final String RECEIVE_EMAIL = email;
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
                  message.setSubject("Doi mat khau");
                  message.setText(genenerateCode());
                  // send message
                  Transport.send(message);

                  resp.getWriter().println("ĐÃ TEST THÀNH CÔNG");
              } catch (MessagingException e) {
                  throw new RuntimeException(e);
              }
          }else{
              resp.getWriter().println("That bai");
          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected String genenerateCode() {
        Random random = new Random();
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String res = "";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < sb.length(); i++) {
            char randomchar = character.charAt(random.nextInt(character.length()));
            res = String.valueOf(sb.append(randomchar));
        }
        return res;
    }
}
