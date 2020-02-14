package com.srdz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ${Description}
 *
 * @author Jiangshengtong
 * @date 2019/11/03
 */

@Controller
public class testController {


    @GetMapping("index")
    public String show() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "customer/login";
    }

    @GetMapping("signUp")
    public String signUp() {
        return "customer/signUp";
    }

    @GetMapping("changePassword")
    public String resetPassword() {
        return "customer/changePassword";
    }
}
