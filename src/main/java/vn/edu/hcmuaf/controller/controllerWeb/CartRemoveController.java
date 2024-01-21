package vn.edu.hcmuaf.controller.controllerWeb;

import vn.edu.hcmuaf.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartRemoveController", value = "/removeproducts")
public class CartRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        int price = Integer.parseInt(req.getParameter("price"));
        HttpSession session = req.getSession();
        ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list");
        if (session != null) {
            if (list.isEmpty()) {
                req.setAttribute("message", "Giỏ hàng trống");
                req.getRequestDispatcher("/views/header.jsp").forward(req, resp);
            } else {
                for (Product product : list) {
                    if (product.getProductName().equalsIgnoreCase(name)) {
                        if (product.getImgURL().equalsIgnoreCase(img)) {
                            if (product.getPrice() == price) {
                                list.remove(product);
                                break;
                            }
                        }
                    }
                }
                session.setAttribute("list", list);
                resp.sendRedirect(req.getContextPath() + "/views/header.jsp");
            }

        }

    }
}
