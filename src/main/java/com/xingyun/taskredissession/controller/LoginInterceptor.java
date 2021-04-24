package com.xingyun.taskredissession.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 如果有当前注解 , 则不需要校验token
        Login login = handlerMethod.getMethodAnnotation(Login.class);

        if (login == null){
            return true;
        }
        String id = request.getSession().getId();
        System.out.println("session id is : " + id);
        Object username = request.getSession().getAttribute("username");

        if (username != null){
            System.out.println("登录成功");
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("没有访问权限");
        return false;
    }

}
