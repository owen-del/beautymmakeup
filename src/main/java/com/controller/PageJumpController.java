package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 跳转页面
@Controller
public class PageJumpController {



    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 登录首页
     */
    @RequestMapping(value = {"/admin/index", "/"}, method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }




}
