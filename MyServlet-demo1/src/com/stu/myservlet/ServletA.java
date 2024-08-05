package com.stu.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
        Cookie cookie1 = new Cookie("keya", "valuea");
        cookie1.setPath("/demo1/servletB"); //提交路径  非路径之中的就能不再提交
        cookie1.setMaxAge(60 * 5); //持久化 cookie  时间为秒
        // 会话级cookie  在本次应用中有效（关闭浏览器打开无效）
        // 持久级cookie  市县内有效(关闭浏览器再打开仍然有效)
        Cookie cookie2 = new Cookie("keyb", "valueb");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
