package vn.edu.hcmuaf.controller.controllerAdmin;

import vn.edu.hcmuaf.dao.ProductDAO;
import vn.edu.hcmuaf.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID sản phẩm từ request parameter
        int productId = Integer.parseInt(request.getParameter("id"));

        // Gọi phương thức từ ProductDAO để lấy thông tin chi tiết sản phẩm
        ProductDAO productDAO = ProductDAO.getInstance();
        Product product = productDAO.getProductByID(productId);

        // Đặt dữ liệu sản phẩm vào request attribute
        request.setAttribute("product", product);

        // Chuyển hướng đến trang product-details.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product-details.jsp");
        dispatcher.forward(request, response);
    }
}
