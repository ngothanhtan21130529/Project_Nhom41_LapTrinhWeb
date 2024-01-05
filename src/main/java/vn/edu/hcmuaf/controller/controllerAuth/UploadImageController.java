package vn.edu.hcmuaf.controller.controllerAuth;

import vn.edu.hcmuaf.service.UpdateProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 20 //20MB
        , maxFileSize = 1024 * 1024 * 20 //20MB ,
        , maxRequestSize = 1024 * 1024 * 100)//100MB
@WebServlet(name = "UploadImageController", value = "/uploadimage")
public class UploadImageController extends HttpServlet {
    private UpdateProfileService updateProfileService = new UpdateProfileService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Part part = req.getPart("file");
        String filename = part.getSubmittedFileName();
        String root = req.getServletContext().getRealPath("/img/user");
        File file = new File(root);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (part != null)
            part.write(root + "/" + filename);
        HttpSession session = req.getSession();
        if (session != null) {
            if (session.getAttribute("username") != null) {
                try {
                    if (updateProfileService.updateImg(filename, (String) session.getAttribute("username"))) {
                        req.setAttribute("notify", "Cập nhật thành công");
                        req.getRequestDispatcher("/views/profile/profile.jsp").forward(req, resp);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

}
