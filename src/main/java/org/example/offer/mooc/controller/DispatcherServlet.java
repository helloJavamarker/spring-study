package org.example.offer.mooc.controller;

import org.example.offer.mooc.controller.frontend.MainPageController;
import org.example.offer.mooc.controller.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截所有请求
 * 解析请求
 * 派发给对应的controller里面的方法进行处理
 */

// 一: 拦截几乎所有请求  /不会拦截jsp请求    /和/*都可以拦截所有请求,但是/*不建议使用,会造成死循环    精确匹配会高于模糊匹配--/*有通配符
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    //解析并处理相关请求
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("before");
        //可以通过获得method路径和方法请求来决定要调用哪个servlet
        System.out.println(req.getMethod());

        //super.service(req, resp);
        if (req.getServletPath() == "/frontend/getmainpageinfo" && req.getMethod() == "GET") {
            new HeadLineOperationController().queryHeadLine(req, resp);
        }/* else if () {   //引入简单工厂方法: 通常使用简单工厂是一个习惯
        // 定义一个工厂类,根据传入参数的不同,返回不同的实例,,这些实例具有共同的父类或者接口
        }*/
        System.out.println("after");
    }

}
