package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.PrintCategoryService;
import vn.edu.hcmuaf.service.PrintProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminDisplayment", value = "/AdminDisplayment")
public class AdminDisplayment extends HttpServlet {
    PrintCategoryService printCategoryService = new PrintCategoryService();
    PrintProductService printProductService = new PrintProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArrayList<Category> categoryArrayList = printCategoryService.getListCategoryFull();
            ArrayList<Product> productArrayList = printProductService.getListProductFull();
            request.setAttribute("categoryArrayList1", categoryArrayList);
            request.setAttribute("productArrayList", productArrayList);
            request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
