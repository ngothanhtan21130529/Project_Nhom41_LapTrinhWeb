package vn.edu.hcmuaf.controller.controllerAdmin.CategoryCRUD;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;
import vn.edu.hcmuaf.service.CategoryService;
import vn.edu.hcmuaf.service.ImageService;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateCategoryStage2", value = "/UpdateCategoryStage2")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 20, //1 MB
        maxFileSize = 1024 * 1024 * 20, //20 MB
        maxRequestSize = 1024 * 1024 * 100 //100 MB
)
public class UpdateCategoryStage2 extends HttpServlet {
    SearchService search=new SearchService();
    CategoryService categoryService=new CategoryService();
    ImageService imageService=new ImageService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String newCategoryName=request.getParameter("categories-name-input");
        String newStatus=request.getParameter("categories-status");
        String categoryID=request.getParameter("categories-order");
        int id=Integer.parseInt(categoryID);
        Category category=search.findCategoryById(id);
        Part filePart = request.getPart("category-new-img");
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/img/data/");
        if(filePart != null && fileName.isEmpty()){
            File currentFile=new File(category.getImgURL());
            fileName=currentFile.getName();
        }else{
            File check = new File(root);
            if (!(check.exists())) check.mkdirs();
            if (filePart != null && !fileName.isEmpty()) {
                filePart.write(root + fileName);
            }
        }
        String newImageURL="/img/data/"+fileName;
        Image image=search.findImageById(category.getImgID());
        image.setImageName(fileName);
        image.setImgURL(newImageURL);
        imageService.updateImage(image);
        category.setCategoryName(newCategoryName);
        category.setStatus(newStatus);
        categoryService.updateCategory(category);
        response.sendRedirect(request.getContextPath()+"/AdminDisplayment");
    }
}
