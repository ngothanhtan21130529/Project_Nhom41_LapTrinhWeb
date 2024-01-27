package vn.edu.hcmuaf.controller.controllerAdmin.ProductCRUD;

import vn.edu.hcmuaf.model.Product;
import vn.edu.hcmuaf.service.ProductService;
import vn.edu.hcmuaf.service.SearchService;
import vn.edu.hcmuaf.service.UpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updateInventories")
public class UpdateInventories extends HttpServlet {
    SearchService service=new SearchService();
    ProductService productService=new ProductService();
    UpdateService updateService=new UpdateService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String pid=req.getParameter("id");
        String name=req.getParameter("name");
        int id=Integer.parseInt(pid);
        String pquantity=req.getParameter("quantity");
        int quantity=Integer.parseInt(pquantity);
        try {
            updateService.updateQuantityProduct(id, quantity);
            resp.sendRedirect(req.getContextPath()+"/admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
