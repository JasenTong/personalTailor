package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.OrderMaster;
import com.srdz.demo.mapper.OrderMasterMapper;
import com.srdz.demo.service.IOrderMasterService;
import com.srdz.demo.util.AliPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements IOrderMasterService {

    AliPay alipay = new AliPay();

    @Autowired
    private IOrderMasterService orderMasterService;

    @Transactional(rollbackFor = Exception.class)
    public Boolean continuePay(OrderMaster orderMaster) throws Exception {
        if (alipay.pay()) {
            orderMaster.setOrderStatus(1);
            this.updateOrderStatus(orderMaster);
            return true;
        } else {
            return false;
        }
    }

    private void updateOrderStatus(OrderMaster orderMaster) {
        QueryWrapper<OrderMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(OrderMaster::getOrderId, orderMaster.getOrderId());
        orderMaster.setOrderStatus(1);
        this.orderMasterService.update(queryWrapper);
    }
}
