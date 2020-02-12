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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

    @Autowired
    private ICustomerLoginService customerLoginService;

    CommonReturn commonReturn = new CommonReturn();

    @GetMapping("signup")
    public CommonReturn customerSignUp(HttpServletRequest request) {
        //1、customerLogin table
        CustomerLogin customerLogin = new CustomerLogin();
        CustomerInf customerInf = new CustomerInf();
        CustomerAddr customerAddr = new CustomerAddr();
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        customerLogin.setUserStatus(1);
        if (null != loginName && null != password) {
            customerLogin.setLoginName(loginName);
            customerLogin.setPassword(password);
        } else {
            return commonReturn.fail();
        }

        //2、customerInf table
        customerInf.setCustomerName(request.getParameter("customerName"));
        Date date = new Date();
        customerInf.setRegisterTime(date);
        customerInf.setBirthday(date);
        customerInf.setCustomerEmail(request.getParameter("customerEmail"));
        customerInf.setCustomerLevel(1);
        customerInf.setGender(request.getParameter("gender"));
        customerInf.setIdentityCardNo("100010100110");
        customerInf.setIdentityCardType(1);
        customerInf.setMobilePhone(request.getParameter("mobilePhone"));
        customerInf.setUserPoint(1);

        //3、customerAddress table
        //default not necessary
        customerAddr.setIsDefault(1);
        customerAddr.setProvince(1);
        customerAddr.setDistrict(1);
        customerAddr.setCity(1);
        customerAddr.setZip(request.getParameter("zip"));
        customerAddr.setAddress(request.getParameter("address"));
        boolean flag = this.customerLoginService.customerSignUp(customerLogin, customerInf, customerAddr);
        if (flag) {
            return commonReturn.success();
        } else {
            return commonReturn.fail();
        }
    }

    @PostMapping("login")
    public ModelAndView login(CustomerLogin customerLogin, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        CustomerLogin customer = getCustomerLoginInfo(customerLogin);
        if (null == customer) {
            mv.addObject(this.commonReturn.fail());
            mv.setViewName("customer/login");
        } else {
            session.setAttribute("customer", customer);
            mv.addObject(this.commonReturn.success());
            mv.addObject("loginName", customer.getLoginName());
            mv.setViewName("index");
        }
        return mv;
    }

    /**
     * @param customerLogin query table of customerLogin
     * @return
     */
    private CustomerLogin getCustomerLoginInfo(CustomerLogin customerLogin) {
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, customerLogin.getLoginName())
                .eq(CustomerLogin::getPassword, customerLogin.getPassword());
        List<CustomerLogin> list = this.customerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
}
