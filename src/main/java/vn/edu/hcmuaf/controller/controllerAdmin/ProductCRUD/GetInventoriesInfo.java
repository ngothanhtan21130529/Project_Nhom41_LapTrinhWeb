package vn.edu.hcmuaf.controller.controllerAdmin.ProductCRUD;

import vn.edu.hcmuaf.model.Inventory;
import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/getInvenInfo")
public class GetInventoriesInfo extends HttpServlet {
    SearchService service=new SearchService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String iid=req.getParameter("id");
        int id=Integer.parseInt(iid);
        try {
            Product productInventories = service.getInventoriesByProductId(id);
            req.setAttribute("inventories",productInventories);
            req.getRequestDispatcher("views/admin/admin-update-inventories.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
