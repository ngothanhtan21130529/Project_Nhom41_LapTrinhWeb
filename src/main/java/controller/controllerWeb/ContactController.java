package controller.controllerWeb;

import DAO.CommentDAO;
import DAO.FeedbackDAO;
import connection.MySqlConnection;
import model.Comment;
import model.Feedback;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(name="ContactController",value="/contact")
public class ContactController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        FeedbackDAO feedbackDAO=FeedbackDAO.getInstance();
        Feedback feedback=new Feedback(name,email,phone,title,content);
        try {
        boolean marked=     feedbackDAO.insertFeedback(feedback);
            if(marked){
                resp.getWriter().println("Thành công");
            }else{
                resp.getWriter().println("Thất bại");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

     
    }
