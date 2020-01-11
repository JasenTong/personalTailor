package com.srdz.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${Description}
 *
 * @author Jiangshengtong
 * @date 2019/11/03
 */
@RestController
public class testController {
    @GetMapping("/index")
    public String show(){
        return "hello";
    }

}
