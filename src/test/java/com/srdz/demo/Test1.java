package com.srdz.demo;

import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.domain.NeedContent;
import com.srdz.demo.service.ICustomerLoginService;
import com.srdz.demo.service.NewCustomerAddrService;
import com.srdz.demo.service.NewNeedContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


/**
 * @FileName: demo
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/12 3:43 下午
 */
@SpringBootTest
public class Test1 {
    private final static String ADDRESS = "上海市普陀区中山北路华东师范大学";

    @Autowired
    private ICustomerLoginService customerLoginService;

    @Autowired
    private NewCustomerAddrService newCustomerAddrService;

    @Autowired
    private NewNeedContentService newNeedContentService;

    /**
     * use in mybatis plus framework
     * it has its get and set constructor
     */
    @Test
    public void addCustomerLogin() {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName("walt");
        customerLogin.setPassword("walt");
        customerLogin.setUserStatus(1);
        this.customerLoginService.save(customerLogin);

    }

    /**
     * add get and set method to object(CustomerLogin)
     */
    @Test
    public void insertCustomerLogin() {
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setLoginName("jasen");
        customerLogin.setPassword("123456");
        customerLogin.setUserStatus(1);
        this.customerLoginService.save(customerLogin);
    }

    /**
     * usee my customized mapper
     */
    @Test
    public void insertAddrData() {
        CustomerAddr customerAddr = new CustomerAddr();
        //in my database, customerId 8 means jasen
        customerAddr.setCustomerId(8);
        customerAddr.setAddress(ADDRESS);
        customerAddr.setProvince(2);
        customerAddr.setCity(1);
        customerAddr.setDistrict(2);
        customerAddr.setZip("23");
        customerAddr.setIsDefault(1);
        this.newCustomerAddrService.inserAddrData(customerAddr);
    }

    @Test
    public void insetNeedContent() {
        NeedContent needContent = new NeedContent();
        needContent.setDesignerId(1);
        needContent.setCustomerId(1);
        needContent.setNeedCount(10);
        needContent.setNeedTitle("蛋糕定制");
        needContent.setContent("hello!jasen's first trying,I will success");
        this.newNeedContentService.insertNeedContent(needContent);
    }

    @Test
    public void insetPlanContent() {
        NeedContent needContent = new NeedContent();
        needContent.setNeedContentId(4);
        needContent.setPlanContent("ok,I will give the plan");
        needContent.setNeedMoney(234.5);
        this.newNeedContentService.insertPlanContentByContentId(needContent);
    }

    @Test
    public void queryNeedContent() {
        System.out.println("show:");
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentService.queryNeedContentByCustomerId(1);
        System.out.println("show");
        System.out.println(list);
        System.out.println("show");
    }

    @Test
    public void queryNeedcontent1() {
        System.out.println("show");
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentService.queryNeedContentByDesignerId(1);
        System.out.println(list);
        System.out.println("show");
    }

    @Test
    public void updateStatus() {
        Integer needContentId = 1;
        Integer status = 100;
        this.newNeedContentService.updateStatus(needContentId,status);
    }

}
