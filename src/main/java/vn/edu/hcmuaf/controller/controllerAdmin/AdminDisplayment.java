package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.CategoryDAO;
import vn.edu.hcmuaf.model.Category;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.model.User;
import vn.edu.hcmuaf.service.PrintCategoryService;
import vn.edu.hcmuaf.service.PrintProductService;
import vn.edu.hcmuaf.service.PrintUserService;

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
    PrintUserService printUserService = new PrintUserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ArrayList<Category> categoryArrayList = printCategoryService.getListCategoryFull();
            ArrayList<Product> productArrayList = printProductService.getListProductFull();
            ArrayList<User> userArrayList = printUserService.getListUserFull();
            request.setAttribute("categoryArrayList", categoryArrayList);
            request.setAttribute("productArrayList", productArrayList);
            request.setAttribute("userArrayList", userArrayList);
            request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> productArrayList = new AdminDisplayment().printProductService.getListProductFull();
        int count = 0;
        System.out.println(count);
        for (Product p : productArrayList) {
            System.out.println(p);
            count++;
        }
        System.out.println(count);
    }
}
