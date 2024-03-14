package com.example.time_login_currency_dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", value = "/translate")
public class DictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String word= request.getParameter("txtSearch");

        Map<String, String> dictionary= new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("love", "tình yêu");
        dictionary.put("happy", "hạnh phúc");

        PrintWriter printWriter= response.getWriter();
        String res= dictionary.get(word);
        String tmp= "<html><h1>%s</h1></html>";
        if(res != null){
            printWriter.printf(tmp, word + "= " + res);
        }
        else {
            printWriter.printf(tmp, "Not found");
        }
    }
}
