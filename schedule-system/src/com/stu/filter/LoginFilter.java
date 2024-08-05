package com.stu.filter;

import com.stu.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author lvlp
 * @create 2024/8/5 22:09
 */
@WebFilter( urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        var session = req.getSession();
        SysUser sysuser = (SysUser) session.getAttribute("sysUser");
        if (sysuser == null) {
//            req.getRequestDispatcher("/login.html");
            resp.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
