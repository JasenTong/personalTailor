package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.mapper.CustomerLoginMapper;
import com.srdz.demo.service.ICustomerAddrService;
import com.srdz.demo.service.ICustomerInfService;
import com.srdz.demo.service.ICustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @FileName: demo
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/12 1:44 下午
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements ICustomerLoginService {

    @Autowired
    private ICustomerLoginService customerLoginService;
    @Autowired
    private ICustomerInfService customerInfService;
    @Autowired
    private ICustomerAddrService customerAddrService;

    private Integer getCustomerId(CustomerLogin customerLogin) {
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, customerLogin.getLoginName())
                .eq(CustomerLogin::getPassword, customerLogin.getPassword());
        List<CustomerLogin> list = this.customerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0).getCustomerId();
        }
    }

    @Transactional
    public Boolean customerSignUp(CustomerLogin customerLogin, CustomerInf customerInf, CustomerAddr customerAddr) {
        if (null != customerLogin && null != customerInf && null != customerAddr) {
            //1、insert into customerLogin
            this.customerLoginService.save(customerLogin);
            //2、get customerId for customerInf and customerAddr
            Integer customerId = this.getCustomerId(customerLogin);
            customerInf.setCustomerId(customerId);
            customerAddr.setCustomerId(customerId);
            //3、insert into customerInf
            this.customerInfService.save(customerInf);
            //4、insert into customerAddr
            this.customerAddrService.save(customerAddr);
            return true;
        }
        return false;
    }
}
