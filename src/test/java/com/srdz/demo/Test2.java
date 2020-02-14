package com.srdz.demo;

import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.domain.DesignerLogin;
import com.srdz.demo.service.IDesignerLoginService;
import com.srdz.demo.util.OrderSnFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2 {

    @Autowired
    private IDesignerLoginService designerLoginService;

    @Test
    public void insertDesignerLogin() {
        DesignerLogin designerLogin = new DesignerLogin();
        designerLogin.setLoginName("jasen");
        designerLogin.setPassword("123456");
        designerLogin.setPageUrl("www.qq.com");
        designerLogin.setUserStatus(1);
        this.designerLoginService.save(designerLogin);
    }

    @Test
    public void generator() {
        OrderSnFactory orderSnFactory = new OrderSnFactory();
        String temp = orderSnFactory.generator();
        System.out.println(temp);
    }



}
