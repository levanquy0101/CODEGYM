package com.example.product_discount_calculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "displayDiscount", value = "/display-discount")
public class displayDiscount extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double price = Double.parseDouble(req.getParameter("price"));
        Integer discount = Integer.parseInt(req.getParameter("discount"));
        String des = req.getParameter("description");

        PrintWriter  writer = resp.getWriter();
        if(price != null && discount != null){
            Double discountAmount = discount * price /100;
            Double priceAfterDiscount = price - discountAmount;

            writer.println("<div>Description: " + des + "</div>");
            writer.println("<div>Discount Amount: " + discountAmount + "</div>");
            writer.println("Discount Price:" + priceAfterDiscount + "</div>");
        }
        else{
            writer.println("Error! Please input all field");
        }
    }
}