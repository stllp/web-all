package com.stu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
//@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String username = filterConfig.getInitParameter("username");
        System.out.println(username);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤前
        System.out.println("Filter1 before doFilter invoked");
        //过滤
        filterChain.doFilter(servletRequest,servletResponse);
        //过滤后
        System.out.println("Filter1 after doFilter invoked");
    }
}
