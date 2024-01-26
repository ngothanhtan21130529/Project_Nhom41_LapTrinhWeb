package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchController", value = "/SearchController")
public class SearchController extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        try{
            String txtSearch=request.getParameter("txtSearch");
            int count= ProductDAO.getInstance().count(txtSearch);
            System.out.println(count);
            String indexString=request.getParameter("index");
            int index=Integer.parseInt(indexString);
            int pageSize=3;
            int endPage=0;
            endPage=count/pageSize;
            if(count%pageSize!=0) endPage++;
//            List<Product>productList=ProductDAO.getInstance().search(txtSearch,index,pageSize);
            request.setAttribute("end",endPage);
//            request.setAttribute("list", productList);
            request.setAttribute("txtSearch", txtSearch);
            request.getRequestDispatcher("/web/search-result.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
