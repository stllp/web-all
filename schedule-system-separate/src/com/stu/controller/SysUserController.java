package com.stu.controller;

import com.stu.common.Result;
import com.stu.common.ResultCodeEnum;
import com.stu.pojo.SysUser;
import com.stu.service.SysUserService;
import com.stu.service.impl.SysUserServiceImpl;
import com.stu.utils.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImpl();

    protected void findByUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
        SysUser sysUser1 = WebUtil.readJson(req, SysUser.class);
        System.out.println(sysUser1);
        SysUser sysUser = userService.findByUsername(sysUser1.getUsername());
        if (sysUser == null) {
            //resp.getWriter().write("OK");
            WebUtil.writeJson(resp, Result.ok("OK"));
        } else {
            //resp.getWriter().write("该用户名已被抢注");
            WebUtil.writeJson(resp, Result.build("该用户名已被抢注", ResultCodeEnum.USERNAME_USED));
        }
    }

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
//        String username = req.getParameter("username");
//        String pwd = req.getParameter("pwd");
        SysUser sysUser1 = WebUtil.readJson(req, SysUser.class);
        System.out.println(sysUser1);
        //将传参注入对象
        SysUser sysUser = new SysUser(null, sysUser1.getUsername(), sysUser1.getUserPwd());
        //调用服务层接口完成注册
        int rows = userService.regist(sysUser);
        if (rows > 0) {
            WebUtil.writeJson(resp, Result.ok("注册成功"));
        } else {
            WebUtil.writeJson(resp, Result.build("该用户名已被抢注", ResultCodeEnum.USERNAME_USED));
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取传参
//        String username = req.getParameter("username");
//        String pwd = req.getParameter("pwd");
        SysUser sysUser1 = WebUtil.readJson(req, SysUser.class);
        System.out.println(sysUser1);
        //将传参注入对象
//        SysUser sysUser = new SysUser(null, username, pwd);
        //调用服务层接口完成注册
        SysUser sysUser = userService.findByUsername(sysUser1.getUsername());
        if (sysUser == null) {
//            resp.sendRedirect("/loginUsernameError.html");
            WebUtil.writeJson(resp, Result.build("用户名错误", ResultCodeEnum.USERNAEM_ERROR));
            return;
        }
        sysUser = userService.findByUsernameAndPwd(sysUser1.getUsername(), sysUser1.getUserPwd());
        if (sysUser != null) {
            HttpSession session = req.getSession();
            session.setAttribute("sysUser", sysUser);
//            resp.sendRedirect("/showSchedule.html");
            WebUtil.writeJson(resp, Result.build(sysUser, ResultCodeEnum.SUCCESS));
            return;
        } else {
            WebUtil.writeJson(resp, Result.build("密码错误", ResultCodeEnum.PASSWORD_ERROR));
        }
    }
}
