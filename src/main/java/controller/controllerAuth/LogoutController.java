package controller.controllerAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy giá trị thông qua request.getParameter được đính kèm trên request
        //khi tạo biến lưu phải trùng tên với tên biến trên thanh url để xử lí

        //kiểm tra nếu session khác null dùng hàm xóa session hiện tại
        String name=req.getParameter("name");
        HttpSession session=req.getSession();
        if(session!=null){
            session.invalidate();
            resp.sendRedirect("");
        }else{
            resp.sendRedirect("");
        }
    }
}
