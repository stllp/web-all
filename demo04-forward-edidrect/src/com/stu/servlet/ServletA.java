package com.stu.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发特点
 * 请求转发通过HttpServletRequest对象获取请求转发器实现
 * 请求转发是服务器内部的行为,对客户端是屏蔽的
 * 客户端只发送了一次请求,客户端地址栏不变
 * 服务端只产生了一对请求和响应对象,这一对请求和响应对象会继续传递给下一个资源
 * 因为全程只有一个HttpServletRequset对象,所以请求参数可以传递,请求域中的数据也可以传递
 * 请求转发可以转发给其他Servlet动态资源,也可以转发给一些静态资源以实现页面跳转
 * 请求转发可以转发给WEB-INF下受保护的资源
 * ·请求转发不能转发到本项目以外的外部资源
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA   执行了 ");
        //请求转发 servletB
        //1、获取一个请求转发器
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
        //2、转发器进行转发动作
        requestDispatcher.forward(req,resp);
    }
}
