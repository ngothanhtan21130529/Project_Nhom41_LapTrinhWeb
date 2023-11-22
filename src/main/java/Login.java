import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "Login" , value= "/lo_gin")
public class Login extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,IllegalStateException {
//        super.doGet(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

            Connection connection = null;
            String username=req.getParameter("username");
            String pass=req.getParameter("password");
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                String url = "jdbc:mysql://localhost:3306/gemstore";
                connection = DriverManager.getConnection(url,"root","");


                String sql="SELECT user_name, password FROM users WHERE user_name = '" + username + "' AND password = '" + pass + "'";
                Statement st=connection.createStatement();
                ResultSet resultSet=st.executeQuery(sql);
                String user=null;
                String password=null;
                while(resultSet.next()){
                    user=resultSet.getString("user_name");
                    password=resultSet.getString("password");
                    if(user.equals(username)&&password.equals(pass)){
                        break;
                    }
                }
                resultSet.close();
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

