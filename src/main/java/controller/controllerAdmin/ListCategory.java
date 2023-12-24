package controller.controllerAdmin;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCategory", value = "/ListCategory")
public class ListCategory extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html; charset=UTF-8");
        try{
            String indexString=request.getParameter("index");
            int index=1;
            if(indexString!=null){
                index=Integer.parseInt(indexString);
            }
            int count= CategoryDAO.count();
            int endPage=count/3;
            if(endPage%3!=0) endPage++;
            ArrayList<Category>categories=CategoryDAO.search(index);
            request.getAttribute("categories-table");
            request.setAttribute("categoriesList",categories);
            request.setAttribute("startPage",index);
            request.setAttribute("endPage",endPage);
            request.getRequestDispatcher("/web/admin.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
