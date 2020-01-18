package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.mapper.CustomerInfMapper;
import com.srdz.demo.service.ICustomerInfService;
import org.springframework.stereotype.Service;

@Service
public class CustomerInfServiceImpl extends ServiceImpl<CustomerInfMapper, CustomerInf> implements ICustomerInfService {
}
