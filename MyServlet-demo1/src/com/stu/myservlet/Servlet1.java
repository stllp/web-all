package com.stu.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession();
        //当JSESSIONID 为空时 会自动创建 JSESSION
        System.out.println(session.getId());
        System.out.println(session.isNew());

        session.setAttribute("username", username);
        session.setMaxInactiveInterval(120); //session 的有效时间 120 秒
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
