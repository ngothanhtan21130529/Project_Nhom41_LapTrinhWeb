package controller.controllerWeb;

import DAO.CommentDAO;
import model.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CommentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment=req.getParameter("comment");
        try {
            CommentDAO.getInstance().insertComment(new Comment(1,1,1,null,null));
            resp.sendRedirect("");
            resp.getWriter().println("Thêm thành công");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}