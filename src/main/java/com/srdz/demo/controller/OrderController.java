package com.srdz.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.OrderMaster;
import com.srdz.demo.service.IOrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    CommonReturn commonReturn = new CommonReturn();

    @Autowired
    private IOrderMasterService orderMasterService;

    /**
     * go on to pay for this order
     *
     * @param orderMaster
     * @return
     * @throws Exception
     */
    @GetMapping("continuepay")
    public CommonReturn continuePay(OrderMaster orderMaster) throws Exception {
        try {
            Boolean flag = this.orderMasterService.continuePay(orderMaster);
            if (flag) {
                return commonReturn.success();
            } else {
                return commonReturn.fail();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    /**
     * update status if product is in shipping
     *
     * @param orderMaster
     * @return
     */
    @GetMapping("shipping")
    public CommonReturn shipping(OrderMaster orderMaster) {
        if (null != orderMaster) {
            QueryWrapper<OrderMaster> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(OrderMaster::getOrderId, orderMaster.getOrderId());
            orderMaster.setOrderStatus(3);
            Boolean flag = this.orderMasterService.update(queryWrapper);
            if (flag) {
                return commonReturn.success();
            } else {
                return commonReturn.fail();
            }
        } else {
            return commonReturn.fail();
        }
    }
}
