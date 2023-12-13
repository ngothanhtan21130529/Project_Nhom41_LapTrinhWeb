package controller.controllerAuth;

import com.sun.mail.util.MailLogger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "SendEmailController", value = "/sendemail")
public class SendEmailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String HOST_NAME = "smtp.gmail.com";

        final int SSL_PORT = 465; // Port for SSL

        final int TSL_PORT = 587; // Port for TLS/STARTTLS

        final String APP_EMAIL = "ngoken102@gmail.com"; // your email

        final String APP_PASSWORD = "ehds asyt yqmu rhpv"; // your password

        final String RECEIVE_EMAIL = "nttan101103@gmail.com";
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
            message.setSubject("Testing Subject");
            message.setText("Welcome to gpcoder.com");
            genenerateCode();

            // send message
            Transport.send(message);

          resp.getWriter().println("ĐÃ TEST THÀNH CÔNG");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    protected String genenerateCode(){
        Random random=new Random();
        String character= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String res="";
        StringBuilder sb=new StringBuilder(10);
        for(int i=0;i<sb.length();i++){
            char randomchar=character.charAt(random.nextInt(character.length()));
          res= String.valueOf(sb.append(randomchar));
        }
        return res;
    }
}
