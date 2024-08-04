package com.stu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 增删改查内容的请求
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //此处代码 每个controller类都会调用 因此放入父类中重写此方法
////        String requestURI = req.getRequestURI();
////        String[] splits = requestURI.split("/");
////        String methodName = splits[splits.length - 1];
////        Class aClass = this.getClass();
////        try {
////            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
////            declaredMethod.setAccessible(true);
////            declaredMethod.invoke(this,req, resp);
////        } catch (Exception e) {
////            System.out.println("异常");
////            e.printStackTrace();
////        }
//        //此种判断过于繁琐  每次新增方法都需要添加判断  改用反射机制处理
////        if (split.equals("add")) {
////            add(req, resp);
////        } else if (split.equals("update")) {
////            update(req, resp);
////        } else if (split.equals("find")) {
////            find(req, resp);
////        } else if (split.equals("remove")) {
////            remove(req, resp);
////        }
//    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("schedule add");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }

}
