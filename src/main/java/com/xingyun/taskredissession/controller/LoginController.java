package com.xingyun.taskredissession.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Value("${spring.application.name}")
    private String applicationName;

    @PostMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo, HttpSession session){



        if ("admin".equals(loginInfo.getUsername()) && "admin".equals(loginInfo.getPassword())){
            System.out.println("登录成功");
            session.setAttribute("username",loginInfo.getUsername());
            return session.getId() + "当前应用名" + applicationName;
        }else {
            return session.getId() + "当前应用名" + applicationName;
        }
    }

}
