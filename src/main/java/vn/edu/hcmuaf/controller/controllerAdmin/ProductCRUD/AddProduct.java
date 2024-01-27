package vn.edu.hcmuaf.controller.controllerAdmin.ProductCRUD;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.service.PrintService;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/goToAddingProduct")
public class AddProduct extends HttpServlet {
    PrintService service=new PrintService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ArrayList<Category> categoryNameArrayList=service.getNameCategory();
        req.setAttribute("categoryNameArrayList", categoryNameArrayList);
        req.getRequestDispatcher("/views/admin/admin-adding-product.jsp").forward(req,resp);
    }
}
