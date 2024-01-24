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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ForgotPasswordController", value = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {
    ForgotPasswordService forgotPasswordService = new ForgotPasswordService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        sendEmail(req, resp, email);
    }

    protected void sendEmail(HttpServletRequest request, HttpServletResponse response, String email) {
        try {
            final String HOST_NAME = "smtp.gmail.com";

            final int SSL_PORT = 465; // Port for SSL

            final int TSL_PORT = 587; // Port for TLS/STARTTLS

            final String APP_EMAIL = "ngoken102@gmail.com"; // your email

            final String APP_PASSWORD = "hfef chqv lick rcfx"; // your password

            final String RECEIVE_EMAIL = forgotPasswordService.getEmail(email);
            if (RECEIVE_EMAIL != null) {
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
                    message.setSubject("Đổi mật khẩu");
                    message.setText("Mật khẩu mới của bạn là:"+ createNewPass());
                    // send message
                    Transport.send(message);
                   request.setAttribute("email",email);
                   request.getRequestDispatcher("/views/login/updatepassword.jsp").forward(request,response);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                }
            }else{
                request.setAttribute("notification","Email không tồn tại");
                request.getRequestDispatcher("/views/login/forgotpassword.jsp").forward(request,response);
            }
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected String createNewPass(){
        String character="qwertyuiopasdfghjklzxcvbnm0123456789!@*";
        String res="";
       Random random=new Random();
       int index=random.nextInt(character.length());
       for(int i=0;i<5;i++){
           res=res+character.charAt(index);
       }
       return res;
    }


}





















