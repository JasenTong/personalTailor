package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.mapper.CustomerLoginMapper;
import com.srdz.demo.service.ICustomerLoginService;
import org.springframework.stereotype.Service;

/**
 * @FileName: demo
 * @Author: wushang
 * @Description: TODO
 * @Date: 2020/1/12 1:44 下午
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements ICustomerLoginService {

}
