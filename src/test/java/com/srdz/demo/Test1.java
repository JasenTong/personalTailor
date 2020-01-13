package com.srdz.demo;

import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.service.ICustomerLoginService;
import com.srdz.demo.service.NewCustomerAddrService;
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
    private final static String ADDRESS="上海市普陀区中山北路华东师范大学";

    @Autowired
    private ICustomerLoginService customerLoginService;

    @Autowired
    private NewCustomerAddrService newCustomerAddrService;

    /**
     * use in mybatis plus framework
     * it has its get and set constructor
     */
    @Test
    public void addCustomerLogin() {
        this.customerLoginService.save(new CustomerLogin(2,"walt", "walt", 1, new Date()));

    }

    /**
     * add get and set method to object(CustomerLogin)
     */
    @Test
    public void insertCustomerLogin(){
        CustomerLogin customerLogin=new CustomerLogin();
        customerLogin.setLoginName("jasen");
        customerLogin.setPassword("123456");
        customerLogin.setUserStatus(1);
        this.customerLoginService.save(customerLogin);
    }

    /**
     * usee my customized mapper
     */
    @Test
    public void insertAddrData(){
        CustomerAddr customerAddr=new CustomerAddr();
        //in my database, customerId 8 means jasen
        customerAddr.setCustomerId(8);
        customerAddr.setAddress(ADDRESS);
        customerAddr.setProvince(2);
        customerAddr.setCity(1);
        customerAddr.setDistrict(2);
        customerAddr.setZip(23);
        customerAddr.setIsDefault(1);
        this.newCustomerAddrService.inserAddrData(customerAddr);
    }

}
