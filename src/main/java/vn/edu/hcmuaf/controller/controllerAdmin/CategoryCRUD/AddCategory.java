package vn.edu.hcmuaf.controller.controllerAdmin.CategoryCRUD;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.dao.ImageDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Image;
import vn.edu.hcmuaf.service.CategoryService;
import vn.edu.hcmuaf.service.ImageService;

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
    ImageService imageService = new ImageService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part filePart = request.getPart("category-img");
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/img/data/");
        String imageURL="";
        if(filePart != null && fileName.isEmpty()){
//            File currentFile=new File(category.getImgURL());
//            fileName=currentFile.getName();
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
        String displayment = request.getParameter("categories-displayment");
        Image image = new Image(imageService.getMaxID(), imageURL, fileName);
        Category category = new Category(categoryService.getMaxID(), categoriesName, displayment, image.getId());
        imageService.addImage(image);
        categoryService.addCategory(category);
        response.sendRedirect(request.getContextPath() + "/AdminDisplayment");
    }
}
