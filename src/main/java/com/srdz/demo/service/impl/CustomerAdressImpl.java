package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.mapper.CustomerAddrMapper;
import com.srdz.demo.service.ICustomerAddrService;
import org.springframework.stereotype.Service;

@Service
public class CustomerAdressImpl extends ServiceImpl<CustomerAddrMapper, CustomerAddr> implements ICustomerAddrService {
}
