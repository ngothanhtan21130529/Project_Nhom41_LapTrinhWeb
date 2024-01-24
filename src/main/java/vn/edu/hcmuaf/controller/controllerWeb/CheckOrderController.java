package vn.edu.hcmuaf.controller.controllerWeb;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vn.edu.hcmuaf.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

//check user type right information or not to order
@WebServlet("/checkorder")
public class CheckOrderController extends HttpServlet {
    private OrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        HttpSession session = req.getSession();
        String regexphone = "^0[0-9]{10}$";
        if (session != null) {
            if (session.getAttribute("username") != null) {
                try {
                    if (orderService.getEmailforOrder(email, session.getAttribute("username").toString()) != null) {
                        if (phone.matches(regexphone)) {
                            req.getRequestDispatcher("/views/web/order/ordersuccess.jsp").forward(req, resp);
                            sendEmail(req, resp, email);
                        }

                    } else {
                        req.setAttribute("notify", "Email ban nhập vào không trùng với tài khoản đã đăng kí trước đó");
                        req.getRequestDispatcher("/views/web/order/order.jsp").forward(req, resp);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    protected void sendEmail(HttpServletRequest request,HttpServletResponse response,String email){
        try {
            final String HOST_NAME = "smtp.gmail.com";
            final int SSL_PORT = 465; // Port for SSL
            final String APP_EMAIL = "ngoken102@gmail.com"; // your email
            final String APP_PASSWORD = "hfef chqv lick rcfx"; // your password
            final String RECEIVE_EMAIL = email;

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
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
