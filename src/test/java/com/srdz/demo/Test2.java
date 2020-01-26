package com.srdz.demo;

import com.srdz.demo.domain.DesignerLogin;
import com.srdz.demo.service.IDesignerLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test2 {

    @Autowired
    private IDesignerLoginService designerLoginService;

    @Test
    public void insertDesignerLogin(){
        DesignerLogin designerLogin=new DesignerLogin();
        designerLogin.setLoginName("jasen");
        designerLogin.setPassword("123456");
        designerLogin.setPageUrl("www.qq.com");
        designerLogin.setUserStatus(1);
        this.designerLoginService.save(designerLogin);
    }



}
