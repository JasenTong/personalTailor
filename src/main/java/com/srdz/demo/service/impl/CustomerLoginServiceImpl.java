package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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

    private static final String REGISTERED = "您已经注册过了或者电话号码输入有误！";

    private static final String SAMENAME = "您使用的名称已经被注册，请换一个名称！";

    private static final String CONDITIONERROR = "注册条件不满足！";

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

    @Override
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

    /**
     * check rule in sign up:
     * 1.if has registered
     * 2.if use some loginName
     *
     * @param customerLogin
     * @param customerInf
     * @return
     */
    @Override
    public String SignUpCheck(CustomerLogin customerLogin, CustomerInf customerInf) {
        String loginName = customerLogin.getLoginName();
        String mobilePhone = customerInf.getMobilePhone();
        if (null != loginName && null != mobilePhone) {
            //1.use mobile phone checking if has registered
            QueryWrapper<CustomerInf> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(CustomerInf::getMobilePhone, customerInf.getMobilePhone());
            List<CustomerInf> list = this.customerInfService.list(queryWrapper);
            //2.check if has same name in the condition of have not registered
            if (CollectionUtils.isEmpty(list)) {
                return queryName(loginName);
            } else {
                return REGISTERED;
            }
        } else {
            //signUp must have mobile phone and login name
            return CONDITIONERROR;
        }
    }

    private String queryName(String loginName) {
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, loginName);
        List<CustomerLogin> list = this.customerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return SAMENAME;
        }
    }

    /**
     * change password by loginName and mobilePhone
     * customerLogin get from session
     *
     * @param customerLogin
     * @param mobilePhone
     * @return
     */
    @Override
    public Boolean changePwd(CustomerLogin customerLogin, String mobilePhone, String pwd) {
        Integer customerId;
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, customerLogin.getLoginName());
        List<CustomerLogin> list = this.customerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return false;
        } else {
            customerLogin = list.get(0);
            customerId = customerLogin.getCustomerId();
            Boolean flag = updatePwd(customerLogin, mobilePhone, customerId, pwd);
            return flag;
        }
    }

    private String queryCusMPhone(Integer customerId) {
        QueryWrapper<CustomerInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerInf::getCustomerId, customerId);
        List<CustomerInf> list = this.customerInfService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0).getMobilePhone();
        }
    }

    private Boolean updatePwd(CustomerLogin customerLogin, String mobilePhone, Integer customerId, String pwd) {
        String res = queryCusMPhone(customerId);
        //if it is self, he or her can change password
        customerLogin.setPassword(pwd);
        if (res.equals(mobilePhone)) {
            Boolean flag = this.customerLoginService.updateById(customerLogin);
            return flag;
        } else {
            return false;
        }
    }
}
