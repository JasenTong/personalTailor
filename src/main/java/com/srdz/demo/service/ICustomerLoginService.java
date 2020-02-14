package com.srdz.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.domain.CustomerLogin;

/**
 * <p>
 * customer登录表 服务类
 * </p>
 *
 * @author walt1012
 * @since 2020-01-11
 */
public interface ICustomerLoginService extends IService<CustomerLogin> {

    public Boolean customerSignUp(CustomerLogin customerLogin, CustomerInf customerInf, CustomerAddr customerAddr);

    public String SignUpCheck(CustomerLogin customerLogin, CustomerInf customerInf);

    public Boolean changePwd(CustomerLogin customerLogin,String mobilePhone,String pwd);

}
