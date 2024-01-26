package vn.edu.hcmuaf.controller.controllerAdmin.CategoryCRUD;

import vn.edu.hcmuaf.service.AddingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "AddCategory", value = "/AddCategory")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 20, //20 MB
        maxFileSize = 1024 * 1024 * 20, //20 MB
        maxRequestSize = 1024 * 1024 * 100 //100 MB
)
public class AddCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    AddingService addingService =new AddingService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part filePart = request.getPart("category-img");
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/img/data/");
        String imageURL="";
        if(filePart != null && fileName.isEmpty()){
            imageURL=null;
        }else{
            File check = new File(root);
            if (!(check.exists())) check.mkdirs();
            if (filePart != null && !fileName.isEmpty()) {
                filePart.write(root + fileName);
                imageURL = "/img/data/" + fileName;
            }
        }
        String categoriesName = request.getParameter("categories-name-input");
        String status = request.getParameter("categories-displayment");
        addingService.CategoryAdding(categoriesName, status, imageURL, fileName);
        response.sendRedirect(request.getContextPath() + "/admin");
    }
}
