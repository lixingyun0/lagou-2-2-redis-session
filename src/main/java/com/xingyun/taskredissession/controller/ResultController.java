package com.xingyun.taskredissession.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/info")
    @Login
    public String getLoginInfo(HttpSession session){
        return session.getAttribute("username").toString()+ "当前应用名" + applicationName;
    }
}
