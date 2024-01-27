package vn.edu.hcmuaf.controller.controllerAdmin.ProductCRUD;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import vn.edu.hcmuaf.model.Image;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.AddingService;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/addProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, //20 MB
        maxFileSize = 1024 * 1024 * 20, //20 MB
        maxRequestSize = 1024 * 1024 * 100 //100 MB
)
public class ProductAdding extends HttpServlet {
    AddingService addingService = new AddingService();
    ImageService imageService = new ImageService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            /*
             * get value
             * */
            req.setCharacterEncoding("UTF-8");
            String category = req.getParameter("category");
            int categoryId = Integer.parseInt(category);
            String price = req.getParameter("price");
            int productPrice = Integer.parseInt(price);
            String sale = req.getParameter("sale");
            int saleProduct = (sale == null) ? 0 : 1;
            String hot = req.getParameter("hot");
            boolean hotProduct = (hot == null) ? false : true;
            String color = req.getParameter("color");
            String opacity = req.getParameter("opacity");
            String size = req.getParameter("size");
            String cuttingGrindingType = req.getParameter("shape");
            String material = req.getParameter("material");
            String name = req.getParameter("name");
            String description = req.getParameter("discription");
            String content = req.getParameter("content");
            String status = req.getParameter("status");
            String weight = req.getParameter("weight");
            String productQuantity=req.getParameter("quantity");
            int quantity=Integer.parseInt(productQuantity);
            /*
             * get Image
             * */
            boolean moved = true;
            boolean moveAgain = false;
            int i = 0;
            List<Part> fileParts = (List<Part>) req.getParts();
            String root = getServletContext().getRealPath("/img/data/");
            List<Image> imageList = new ArrayList<>();
            for (Part filePart : fileParts) {
                String fileName = filePart.getSubmittedFileName();
                if (fileName == null) {
                    continue;
                } else if (filePart != null && !fileName.isEmpty()) {
                    File checkSecond = new File(root);
                    fileName = addingService.generateNewName(fileName, name, ++i);
                    if (!checkSecond.exists()) checkSecond.mkdirs();
                    if (filePart != null && !fileName.isEmpty()) {
                        filePart.write(root + fileName);
                        String imageURL = "/img/data/" + fileName;
                        Image image = new Image(imageService.getMaxID(), imageURL, fileName);
                        imageService.addImage(image);
                        imageList.add(image);
                    }
                } else {
                    if (moved) {
                        resp.sendRedirect(req.getContextPath() + "/goToAddingProduct?imgProductIsNull=imgProductIsNull");
                        moveAgain = true;
                        break;
                    }
                }
            }
            if (!moveAgain) {
                Image thumbnail = imageList.get(0);
                addingService.productAdding(categoryId, productPrice, hotProduct,
                        saleProduct, color, opacity, size, cuttingGrindingType, material, name, description,
                        content, status, thumbnail.getId(), weight, quantity);
                resp.sendRedirect(req.getContextPath() + "/admin");
            } else {
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
