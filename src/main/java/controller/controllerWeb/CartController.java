package controller.controllerWeb;

import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
