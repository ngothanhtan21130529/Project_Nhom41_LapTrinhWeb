package vn.edu.hcmuaf.controller.controllerAdmin;


import vn.edu.hcmuaf.model.ProductDetail;
import vn.edu.hcmuaf.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/product-details")
public class ProductDetailController extends HttpServlet {
    private ProductService productService;

    public ProductDetailController() throws SQLException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Lấy ID sản phẩm từ request (cần điều chỉnh tùy theo cách bạn truyền ID)
        int productId = Integer.parseInt(request.getParameter("productId"));

// Lấy chi tiết sản phẩm dựa trên ID
        ProductDetail productDetail = productService.getProductByID(productId);


// Thiết lập giá trị cho sản phẩm chi tiết
        request.setAttribute("productDetail", productDetail);


        // Chuyển hướng đến trang hiển thị chi tiết sản phẩm
        RequestDispatcher dispatcher = request.getRequestDispatcher("../webapp/views/web/product/product-details.jsp");
        dispatcher.forward(request, response);
        System.out.println("hihi" + productDetail.getColor());
    }
}

