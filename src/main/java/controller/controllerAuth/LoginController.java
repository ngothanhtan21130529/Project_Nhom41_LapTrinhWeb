package controller.controllerAuth;

import DAO.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="LoginController",value="/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy giá trị đầu vào từ form
        String username=req.getParameter("username");
        String pass=req.getParameter("password");
        boolean remember= Boolean.parseBoolean(req.getParameter("checkbox"));
        //tạo UserDAO
        UserDAO userDAO=UserDAO.getInstance();
        User user= null;
        try {
            user = userDAO.selectInformation(username,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user.getRole().getRoleName().equals("Admin")){
            HttpSession session= req.getSession();
            resp.sendRedirect("/web/admin.jsp");
        }else if (user.getRole().getRoleName().equals("User")){
            if(remember){

                Cookie account=new Cookie("username",username);
                Cookie password=new Cookie("password",pass);
                account.setMaxAge(12*24);
                password.setMaxAge(12*24);
                resp.addCookie(account);
                resp.addCookie(password);
            }
            HttpSession session=req.getSession();
            resp.sendRedirect("/web/admin.jsp");
        }else{
            HttpSession session=req.getSession();
            resp.getWriter().println("Đăng nhập thất bại");
        }

        }







    public static void main(String[] args) {


    }
}
