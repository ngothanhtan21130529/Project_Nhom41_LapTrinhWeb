package vn.edu.hcmuaf.controller.controllerWeb;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.OrderManageService;
import vn.edu.hcmuaf.service.OrderService;
import vn.edu.hcmuaf.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//check user type right information or not to order
@WebServlet("/checkorder")
public class CheckOrderController extends HttpServlet {
    private OrderService orderService = new OrderService();
    private OrderManageService orderManageService = new OrderManageService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession();
        Map<String, Product> orders = (HashMap<String, Product>) req.getSession().getAttribute("listorders");
        int total = (int) req.getSession().getAttribute("totalprice");
        if (session != null) {
            if (session.getAttribute("username") != null) {
                try {
                    if (orderService.getEmailforOrder(session.getAttribute("username").toString()) != null) {
                        sendEmail(req, resp, orderService.getEmailforOrder(session.getAttribute("username").toString()), orders,total);
                        UserService userService = new UserService();
                        int userid = userService.getUserId(session.getAttribute("username").toString());
                        for (Map.Entry<String, Product> entry : orders.entrySet()) {
                            String key = entry.getKey();
                            Product value = entry.getValue();
                            orderService.insertOrder(userService.getUserDAO(),session.getAttribute("username").toString(),total);
                           orderManageService.insertOrderDetail(value.getId(),orderService.getMaxId(),Integer.parseInt(key),total,"pending",address,phone);
                        }


                        PrintWriter pr = resp.getWriter();
                        pr.println("Thêm thành công");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    protected void sendEmail(HttpServletRequest request, HttpServletResponse response, String email, Map<String, Product> orders,int total) {
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

                // Subject and content of the email
                message.setSubject("Chúc mừng! Bạn đã đặt hàng thành công");

                // Construct HTML content with product information and total
                StringBuilder content = new StringBuilder();
                content.append("<p>Bạn đã đặt hàng thành công. Đơn hàng của bạn bao gồm các sản phẩm sau:</p>");
                for (Map.Entry<String, Product> entry : orders.entrySet()) {
                    Product product = entry.getValue();
                    content.append("<p>").append(product.getProductName()).append(" - ").append(product.getPrice()).append("</p>");
                }

                content.append("<p>Tổng số tiền: ").append(total).append("</p>");

                message.setContent(content.toString(), "text/html, charset=utf-8");

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


