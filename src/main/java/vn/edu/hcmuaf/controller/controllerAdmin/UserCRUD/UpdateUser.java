package vn.edu.hcmuaf.controller.controllerAdmin.UserCRUD;

import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.SearchService;
import vn.edu.hcmuaf.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    SearchService service=new SearchService();
    UpdateService updateService=new UpdateService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid=req.getParameter("id");
        int id=Integer.parseInt(uid);
        String role=req.getParameter("role");
        String username=req.getParameter("username");
        String fullName=req.getParameter("full-name");
        String password=req.getParameter("password");
        updateService.updateUserInfo(id,role,username,fullName,password);
    }
}
