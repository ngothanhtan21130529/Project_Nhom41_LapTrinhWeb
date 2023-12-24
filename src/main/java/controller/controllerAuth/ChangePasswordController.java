package controller.controllerAuth;
import DAO.UserDAO;
import connection.MySqlConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(name="ChangePasswordController",value="/changepassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String mail=req.getParameter("email");
        String currentpass=req.getParameter("currentpassword");
        String newpass=req.getParameter("newpassword");
        String repeatpassword=req.getParameter("repeatpassword");
        UserDAO userDAO=UserDAO.getInstance();
        try {
            if(userDAO.getEmail(mail).equals(mail)){
                if(!currentpass.equals(newpass)&&newpass.equals(repeatpassword)){
                    HttpSession session= req.getSession();
                    req.setAttribute("account",mail);
                    req.setAttribute("pass",newpass);
                    resp.sendRedirect(req.getContextPath()+"/result");
                }
            }else{
                resp.getWriter().println("That bai");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}