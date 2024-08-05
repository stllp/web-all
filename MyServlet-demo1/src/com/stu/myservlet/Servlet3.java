package com.stu.myservlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域
        req.setAttribute("req","req");

        //会话域
        HttpSession session = req.getSession();
        session.setAttribute("session","session");

        //应用域
        ServletContext application = req.getServletContext();
        application.setAttribute("application","application");

        System.out.println(req.getAttribute("req"));

        //请求转发
        req.getRequestDispatcher("/servlet4").forward(req,resp);
    }
}
