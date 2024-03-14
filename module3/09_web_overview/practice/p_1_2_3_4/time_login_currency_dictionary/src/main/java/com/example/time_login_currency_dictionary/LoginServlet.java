package com.example.time_login_currency_dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user= request.getParameter("username");
        String pass= request.getParameter("password");

        PrintWriter printWriter= response.getWriter();
        String res= "<html><h1>%s</h1></html>";

        if("admin".equals(user) && "admin".equals(pass)){
            printWriter.printf(res, "Welcome " + user);
        }
        else {
            printWriter.printf(res, "Login Error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }
}
