package vn.edu.hcmuaf.controller.controllerAdmin.ProductCRUD;

import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.PrintService;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getProducts")
public class UpdateProduct extends HttpServlet {
    SearchService service=new SearchService();
    PrintService printService=new PrintService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid=req.getParameter("id");
        int id=Integer.parseInt(pid);
        Product product=service.getProductWithId(id);
        ArrayList<Category> categoryNameList=printService.getNameCategory();
        req.setAttribute("categoryNameList", categoryNameList);
        req.setAttribute("productElement", product);
        req.getRequestDispatcher("views/admin/admin-product-update.jsp").forward(req,resp);
    }
}
