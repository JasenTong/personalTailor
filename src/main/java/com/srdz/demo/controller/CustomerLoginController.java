package com.srdz.demo.controller;

import com.srdz.demo.common.ResultInfo;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.service.ICustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName: demo
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/12 1:46 下午
 */

@RestController
@RequestMapping("login")
public class CustomerLoginController {

    @Autowired
    private ICustomerLoginService customerLoginService;

    @RequestMapping("addCustomerLogin")
    public ResultInfo addCustomerLogin(CustomerLogin customerLogin) {
        try {
            this.customerLoginService.save(customerLogin);
            return ResultInfo.ADD_SUCCESS;
        } catch (Exception e) {
            return ResultInfo.ADD_ERROR;
        }
    }
}
