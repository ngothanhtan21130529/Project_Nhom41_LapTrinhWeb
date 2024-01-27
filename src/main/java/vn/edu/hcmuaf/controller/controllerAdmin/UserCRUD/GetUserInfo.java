package vn.edu.hcmuaf.controller.controllerAdmin.UserCRUD;

import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet {
    SearchService service=new SearchService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid=req.getParameter("id");
        int id=Integer.parseInt(uid);
        User user=service.findUserById(id);
        req.setAttribute("userInfo",user);
        req.getRequestDispatcher("/views/admin/admin-update-user.jsp").forward(req,resp);
    }
}
