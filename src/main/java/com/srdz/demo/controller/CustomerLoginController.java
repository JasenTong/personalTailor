package com.srdz.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.service.ICustomerAddrService;
import com.srdz.demo.service.ICustomerInfService;
import com.srdz.demo.service.ICustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

    @Autowired
    private ICustomerInfService iCustomerInfService;
    @Autowired
    private ICustomerLoginService iCustomerLoginService;
    @Autowired
    private ICustomerAddrService iCustomerAddrService;

    CommonReturn commonReturn = new CommonReturn();

    @GetMapping("signUp")
    public CommonReturn customerSignUp(HttpServletRequest request) {
        CustomerLogin customerLogin = new CustomerLogin();
        //read data
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        customerLogin.setLoginName(loginName);
        customerLogin.setPassword(password);
        //default status
        customerLogin.setUserStatus(1);
        boolean flag = this.iCustomerLoginService.save(customerLogin);
        //add data to customer_inf and customer_addr
        if (true == flag) {
            int customerId = getCustomerLoginInfo(customerLogin).getCustomerId();
            boolean flag1 = insertCustomerInf(request, customerId);
            boolean flag2 = insertCustomerAddr(request, customerId);
            if (flag1 && flag2) {
                return this.commonReturn.success();
            } else {
                return this.commonReturn.fail();
            }
        } else {
            return this.commonReturn.fail();
        }
    }

    @GetMapping("login")
    public CommonReturn login(CustomerLogin customerLogin, HttpSession session) {
        CustomerLogin customer = getCustomerLoginInfo(customerLogin);
        if (null == customer) {
            return this.commonReturn.fail();
        } else {
            session.setAttribute("costumer", customer);
            return this.commonReturn.success();
        }
    }

    private CustomerLogin getCustomerLoginInfo(CustomerLogin customerLogin) {
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, customerLogin.getLoginName())
                .eq(CustomerLogin::getPassword, customerLogin.getPassword());
        List<CustomerLogin> list = this.iCustomerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    private boolean insertCustomerInf(HttpServletRequest request, int customerId) {
        CustomerInf customerInf = new CustomerInf();
        customerInf.setCustomerName(request.getParameter("customerName"));
        Date date=new Date();
        customerInf.setRegisterTime(date);
        customerInf.setBirthday(date);
        customerInf.setCustomerEmail(request.getParameter("customerEmail"));
        customerInf.setCustomerId(customerId);
        customerInf.setCustomerLevel(1);
        customerInf.setGender(request.getParameter("gender"));
        //default not necessary
        customerInf.setIdentityCardNo("100010100110");
        customerInf.setIdentityCardType(1);
        customerInf.setMobilePhone(request.getParameter("mobilePhone"));
        customerInf.setUserPoint(1);
        boolean flag = this.iCustomerInfService.save(customerInf);
        return flag;
    }

    private boolean insertCustomerAddr(HttpServletRequest request, int customerId) {
        CustomerAddr customerAddr = new CustomerAddr();
        customerAddr.setCustomerId(customerId);
        //default not necessary
        customerAddr.setIsDefault(1);
        customerAddr.setProvince(1);
        customerAddr.setDistrict(1);
        customerAddr.setCity(1);
        customerAddr.setZip(request.getParameter("zip"));
        customerAddr.setAddress(request.getParameter("address"));
        boolean flag = this.iCustomerAddrService.save(customerAddr);
        return flag;
    }
}
