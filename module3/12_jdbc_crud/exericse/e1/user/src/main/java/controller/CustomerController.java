package controller;

import model.Customer;
import service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerController", urlPatterns = "/customer")
public class CustomerController extends HttpServlet {
    private CustomerService customerService= new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        switch (action){
            case "save":
                String sid= request.getParameter("id");
                int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                String name= request.getParameter("name");
                String email= request.getParameter("email");
                String country= request.getParameter("country");
                Customer customer= new Customer(id, name, email, country);
                customerService.save(customer);
        }

        response.sendRedirect("/customer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action== null) action= "";

        switch (action){
            case "edit":
                int id= Integer.parseInt(request.getParameter("id"));
                Customer customer= customerService.getById(id);
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("customer/add.jsp").forward(request, response);
                break;
            case "delete":
                customerService.delete(Integer.parseInt(request.getParameter("id")));
                default:
                    request.setAttribute("customers", customerService.getAll());
                    request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        }
    }
}
