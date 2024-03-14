package com.example.time_login_currency_dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CurrencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("currency.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate= Float.parseFloat(request.getParameter("rate"));
        float amount= Float.parseFloat(request.getParameter("amount"));
        PrintWriter printWriter= response.getWriter();
        printWriter.printf("<html><h1>%s</h1></html>", rate* amount);
    }
}
