package com.srdz.demo;

import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.service.ICustomerLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @FileName: demo
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/12 3:43 下午
 */
@SpringBootTest
public class Test1 {

    @Autowired
    private ICustomerLoginService customerLoginService;

    @Test
    public void addCustomerLogin() {
        this.customerLoginService.save(new CustomerLogin(2,"walt", "walt", 1, new Date()));

    }
}
