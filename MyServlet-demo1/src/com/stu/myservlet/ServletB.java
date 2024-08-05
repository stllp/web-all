package com.stu.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            System.out.println(cookies[i].getName() +":"+cookies[i].getValue());
//        }
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() +":"+cookie.getValue());
            }
        }

    }
}
