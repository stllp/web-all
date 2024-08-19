package com.stu.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 拦截所有请求
//@WebFilter(urlPatterns = "/*")
public class CrosFilter implements Filter {
    // 初始化方法，一般不用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 跨域解决
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            response.getWriter().write("OK");
        } else {
            // 放行函数
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    // 销毁函数
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

