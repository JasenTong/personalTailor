package com.srdz.demo.service.impl;

import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.mapper.NewCustomerAddrMapper;
import com.srdz.demo.service.NewCustomerAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewCustomerAddrServiceImpl implements NewCustomerAddrService {
    @Autowired
    private NewCustomerAddrMapper newCustomerAddrMapper;

    public void inserAddrData(CustomerAddr customerAddr) {
        this.newCustomerAddrMapper.insertAddrData(customerAddr);
    }
}
