package com.example.product_discount_calculator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "TestFilter", urlPatterns="/display-discount")
public class TestFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init filter");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("do filter");
        chain.doFilter(request, response);
    }
}
