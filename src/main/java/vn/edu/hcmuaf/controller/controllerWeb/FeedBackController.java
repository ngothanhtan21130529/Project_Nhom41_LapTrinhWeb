package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Feedback;
import vn.edu.hcmuaf.service.FeedBackService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="FeedBackController",value="/feedback")
public class FeedBackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/contact.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        FeedBackService feedBackService=new FeedBackService();
        String fullname=req.getParameter("fullname");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        int id=0;
        Feedback feedback=new Feedback(id,fullname,email,phone,title,content);
        try {
            if(feedBackService.insertFeedBack(feedback)){
                req.getRequestDispatcher("/views/contact.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("/views/contact.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
