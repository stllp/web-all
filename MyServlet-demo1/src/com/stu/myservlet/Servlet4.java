package com.stu.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域 切换请求 值就被初始化
        System.out.println("req=" + req.getAttribute("req"));
        //会话域 关闭浏览器器 值就被初始化
        System.out.println("session=" + req.getSession().getAttribute("session"));
        //应用域  重庆服务器 值被初始化
        System.out.println("application=" + req.getServletContext().getAttribute("application"));
    }
}
