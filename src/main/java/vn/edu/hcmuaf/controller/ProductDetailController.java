package vn.edu.hcmuaf.controller;

import vn.edu.hcmuaf.service.ProductService;
import vn.edu.hcmuaf.model.ProductDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/productDetail")
public class ProductDetailController extends HttpServlet {
    private ProductService productService;

    public ProductDetailController() throws SQLException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Lấy ID sản phẩm từ request
            int productId = Integer.parseInt(request.getParameter("id"));

            // Gọi phương thức để lấy thông tin chi tiết sản phẩm theo ID
            ProductDetail productDetail = productService.getProductByID(productId);

            // Đặt thông tin sản phẩm vào thuộc tính request
            request.setAttribute("productDetail", productDetail);

            // Chuyển hướng request và response đến trang JSP để hiển thị thông tin sản phẩm
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/product/product-details.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Xử lý ngoại lệ theo nhu cầu của bạn
            response.sendRedirect("/error-page"); // Chuyển hướng đến trang lỗi nếu có lỗi
        }
    }
}
