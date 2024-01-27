package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchController", value = "/SearchController")
public class SearchController extends HttpServlet {
    SearchService service=new SearchService();
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String txtSearch=request.getParameter("txtSearch");
            ArrayList<Product> product=service.searchProduct(txtSearch);
            request.setAttribute("txtSearch", txtSearch);
            request.setAttribute("productListSearch", product);
            request.getRequestDispatcher("/web/search-result.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
