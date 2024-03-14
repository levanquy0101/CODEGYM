package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;
import util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService= new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        int id= CommonUtil.toInt(request.getParameter("id"));

        switch (action){
            case "delete":
                productService.delete(id);
                break;
            case "search":
                String search= request.getParameter("search");
                request.setAttribute("products", productService.search(search));
                request.getRequestDispatcher("index.jsp").forward(request, response);
            default:
                String name= request.getParameter("name");
                double price= Double.parseDouble(request.getParameter("price"));
                String des= request.getParameter("des");
                String manufacture= request.getParameter("manufacture");
                Product product= new Product(id, name, price, des, manufacture);
                productService.save(product);
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
