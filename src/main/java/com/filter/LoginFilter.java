package com.filter;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginFilter implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求路径
        String url = request.getRequestURI();
        // 进入登陆页面放行
        if(url.contains("login")){
            return true;
        }

        // 防止用户点击返回按钮后返回到已经登陆的页面
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // 用户已经登陆放行
        if(request.getSession().getAttribute("loginUser") != null){
            return true;
        }

        // 进入登录页面
        response.sendRedirect("/");
        return false;
    }
}