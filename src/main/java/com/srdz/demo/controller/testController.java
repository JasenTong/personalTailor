package com.srdz.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${Description}
 *
 * @author Jiangshengtong
 * @date 2019/11/03
 */

@Controller
@RequestMapping("index")
public class testController {
    @RequestMapping("hello")
    public String show() {
        return "index";
    }

}
