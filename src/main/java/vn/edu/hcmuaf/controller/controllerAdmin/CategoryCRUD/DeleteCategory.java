package vn.edu.hcmuaf.controller.controllerAdmin.CategoryCRUD;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;
import vn.edu.hcmuaf.service.CategoryService;
import vn.edu.hcmuaf.service.DeleteService;
import vn.edu.hcmuaf.service.ImageService;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategory", value = "/DeleteCategory")
public class DeleteCategory extends HttpServlet {
    DeleteService deleteService=new DeleteService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String categoryID=request.getParameter("id");
        int id=Integer.parseInt(categoryID);
        deleteService.CategoryDeleting(id);
        response.sendRedirect(request.getContextPath()+"/admin");
    }
}
