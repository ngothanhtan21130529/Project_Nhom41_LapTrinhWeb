package controller.controllerWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,  {

        Connection connection = null;
        String username=req.getParameter("username");
        String pass=req.getParameter("password");
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/gemstore";
            connection = DriverManager.getConnection(url,"root","");


            String sql="SELECT user_name, password,roles.name FROM users join roles on users.role_id=roles.id where  user_name = '" + username + "' AND password = '" + pass + "'AND roles.name='admin'" ;
            Statement st=connection.createStatement();
            ResultSet resultSet=st.executeQuery(sql);
            String user=null;
            String password=null;
            String role=null;
            while(resultSet.next()){
                user=resultSet.getString("user_name");
                password=resultSet.getString("password");
                role=resultSet.getString("roles.name");
                if(user.equals(username)&&password.equals(pass)&&role.equals("admin")){
                    break;
                }
            }
            resultSet.close();
            st.close();
            connection.close();
            if(username.equals(user)&&pass.equals(password)){


                RequestDispatcher requestDispatcher= req.getRequestDispatcher("index.jsp");
                req.setAttribute("user", "Ngo Thanh Tan");
                requestDispatcher.forward(req,resp);



            }else{
                resp.getWriter().println("Kết nối khong thành công");
            }
//'            System.out.println("Kết nối thành công");'
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
