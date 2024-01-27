package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaginationController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // lấy dữ liệu từ lớp productDAO
//        //tạo arraylist duyệt qua từng phần tử
//        //dùng 2 vòng lặp 1 vòng là duyệt qua từng trang vòng thứ 2 là duyệt qua các phần tử
//        //cứ mỗi khi qua 1 trang mới chúng ta sẽ lấy thứ tự phần cuối ở trang trước cộng thêm 1 để duyệt
//        //điều kiện dừng để duyệt đúng số lượng phần tử cần cho mỗi trang là lấy thứ tự của trang đang duyệt nhân cho số lượng phần tử chia đều cho mỗi trang
//        pagination(req,resp);
//    }
//    protected void pagination(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        //đang test
//        String test=request.getParameter("test");
//        ProductDAO productDAO=ProductDAO.getInstance();
//        //số lượng phần tử lấy từ database
//        int items=productDAO.count(test);
//        //số lượng phằn tử cho 1 trang
//        int eachPage=16;
//        //số trang cần chia
//        int page=items/eachPage;
//        if(items%eachPage!=0){
//            page++;
//        }
//        request.setAttribute("page",page);
//        RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
//        requestDispatcher.forward(request,response);
//
//    }
}
