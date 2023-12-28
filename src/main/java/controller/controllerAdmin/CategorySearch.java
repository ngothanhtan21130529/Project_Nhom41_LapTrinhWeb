package controller.controllerAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategorySearch", value = "/CategorySearch")
public class CategorySearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textSearch=request.getParameter("categories-search");
        String searchByCategories=request.getParameter("search-by-categories");
        if(searchByCategories.equals("find-by-id")){

        }
        System.out.println(searchByCategories);
    }
}
