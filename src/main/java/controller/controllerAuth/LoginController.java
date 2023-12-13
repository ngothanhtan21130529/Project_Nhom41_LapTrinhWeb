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

@WebServlet(name="LoginController",value="/CheckLogin")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            checkLogin(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    protected void checkLogin(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        //lấy giá trị đầu vào từ form
        String username=request.getParameter("name");
        String pass=request.getParameter("pass");
        //tạo UserDAO
        UserDAO userDAO=UserDAO.getInstance();
        List<User> list=userDAO.selectInformation();
        //duyệt qua từng phần tử
        for(User user:list){
            if(user.getName().equals(username)&&user.getPassword().equals(pass)&&user.getRole().getRoleName().equals("Admin")){
                HttpSession session=request.getSession();
                RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("admin.jsp");
                requestDispatcher.forward(request,response);
                break;
            } else if (user.getName().equals(username)&&user.getPassword().equals(pass)&&user.getRole().getRoleName().equals("User")) {
                HttpSession session=request.getSession();
                RequestDispatcher requestDispatcher=session.getServletContext().getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
                break;
            }else{
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
                requestDispatcher.forward(request,response);
                break;
            }

        }

    }
    protected void createCookies(HttpServletRequest request,HttpServletResponse response,String username,String password){
        String remember=request.getParameter("checkbox");
        if(remember!=null) {
            Cookie user = new Cookie("username", username);
            Cookie pass = new Cookie("pass", password);
            response.addCookie(user);
            response.addCookie(pass);
        }
    }
}
