package controller.controllerAdmin;


import DAO.CategoryDAO;
import DAO.ImageDAO;
import model.Category;
import model.Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "UploadController", value = "/UploadController")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 20, //1 MB
        maxFileSize = 1024 * 1024 * 20, //20 MB
        maxRequestSize = 1024 * 1024 * 100 //100 MB
)
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("category-img");
        String fileName = filePart.getSubmittedFileName();
        String root = getServletContext().getRealPath("/img/data/");
        File check = new File(root);
        if (!(check.exists())) check.mkdirs();
        if (filePart!=null) {
            filePart.write(root+fileName);
        }
        String categoriesOrderInput=request.getParameter("categories-order-input");
        int categoriesOrder=0;
        if(categoriesOrderInput!=null&&categoriesOrderInput.matches("^(?=.*[0-9])$")){
            categoriesOrder= Integer.parseInt(categoriesOrderInput);
            String categoriesName=request.getParameter("categories-name-input");
            String displayment=request.getParameter("categories-displayment");
            Image image=new Image(ImageDAO.getMaxID()+1,root+fileName, fileName);
            Category category=new Category(categoriesOrder, categoriesName,displayment, image);
            ImageDAO.getInstance().insert(image);
            CategoryDAO.getInstance().insert(category);
            response.sendRedirect(request.getContextPath()+"/ListCategory");
        }else{
            response.getWriter().print("Sai định dạng, số thứ tự chỉ lấy số, " +
                    "không lấy chữ và các ký tự khác");
        }

    }
}
