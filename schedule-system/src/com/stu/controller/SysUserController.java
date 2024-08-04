package com.stu.controller;

import com.stu.pojo.SysUser;
import com.stu.service.SysUserService;
import com.stu.service.impl.SysUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 注册接口 完成人员的注册操作
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传参
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        //将传参注入对象
        SysUser sysUser = new SysUser(null, username, pwd);
        //调用服务层接口完成注册
        int rows = userService.regist(sysUser);
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传参
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        //将传参注入对象
//        SysUser sysUser = new SysUser(null, username, pwd);
        //调用服务层接口完成注册
        SysUser sysUser = userService.findByUsername(username);
        if (sysUser == null) {
            resp.sendRedirect("/loginUsernameError.html");
            return;
        }
        sysUser = userService.findByUsernameAndPwd(username,pwd);
        if (sysUser != null) {
            resp.sendRedirect("/showSchedule.html");
        } else {
            resp.sendRedirect("/loginUsernameError.html");
        }
    }
}
