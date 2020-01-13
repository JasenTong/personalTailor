package com.srdz.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.srdz.demo.domain.CustomerAddr;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCustomerAddrMapper {

    /**
     * add new customer address
     *
     * @param customerAddr adress object
     */
    public void insertAddrData(CustomerAddr customerAddr);

}
