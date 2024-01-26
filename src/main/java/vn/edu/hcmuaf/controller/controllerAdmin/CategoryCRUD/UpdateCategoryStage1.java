package vn.edu.hcmuaf.controller.controllerAdmin.CategoryCRUD;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryStage1", value = "/getCategory")
public class UpdateCategoryStage1 extends HttpServlet {
    SearchService service=new SearchService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String categoryID=request.getParameter("id");
        int id=Integer.parseInt(categoryID);
        Category category= service.findCategoryById(id);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/views/admin/admin-category-update.jsp").forward(request,response);
    }
}
