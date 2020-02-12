package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srdz.demo.domain.*;
import com.srdz.demo.mapper.NewNeedContentMapper;
import com.srdz.demo.service.*;
import com.srdz.demo.util.AliPay;
import com.srdz.demo.util.OrderSnFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewNeedContnetServiceImpl implements NewNeedContentService {

    @Autowired
    private NewNeedContentMapper newNeedContentMapper;
    @Autowired
    private ICustomerInfService customerInfService;
    @Autowired
    private ICustomerAddrService customerAddrService;
    @Autowired
    private IOrderMasterService orderMasterService;
    @Autowired
    private IOrderDetailService orderDetailService;

    public void insertNeedContent(NeedContent needContent) {
        this.newNeedContentMapper.insertNeedConttent(needContent);
    }

    public void insertPlanContentByContnetId(NeedContent needContent) {
        this.newNeedContentMapper.insertPlanContentByContnetId(needContent);
    }

    public List<NeedContent> queryNeedContentByCustomerId(Integer customerId) {
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentMapper.queryNeedContentByCustomerId(customerId);
        return list;
    }

    public List<NeedContent> queryNeedContentByDesignerId(Integer designerId) {
        List<NeedContent> list = new ArrayList<>();
        list = this.newNeedContentMapper.queryNeedContentByDesignerId(designerId);
        return list;
    }

    public void updateStatus(Integer needContentId, Integer status) {
        this.newNeedContentMapper.updateStatus(needContentId, status);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean confirm(OrderMaster orderMaster, NeedContent needContent) throws Exception {
        try {
            if (null != orderMaster && null != needContent) {
                //1、get customer information
                CustomerInf customerInf = new CustomerInf();
                CustomerAddr customerAddr = new CustomerAddr();
                OrderDetail orderDetail = new OrderDetail();
                AliPay aliPay = new AliPay();
                Integer cutomerId = needContent.getCustomerId();
                customerInf = this.getCustomerInf(cutomerId);
                customerAddr = this.getCustomerAddr(cutomerId);

                //2、fill order master
                //2.1、call alipay to test if it is successful
                //1 means have paid,and 2 means there is something wrong
                if (aliPay.pay()) {
                    orderMaster.setOrderStatus(1);
                } else {
                    orderMaster.setOrderStatus(2);
                }
                OrderSnFactory orderSnFactory = new OrderSnFactory();
                String orderSn = orderSnFactory.generator() + cutomerId;
                orderMaster.setOrderSn(orderSn);
                orderMaster.setCustomerId(cutomerId);
                orderMaster.setShippingUser(customerInf.getCustomerName());
                orderMaster.setProvince(1);
                orderMaster.setCity(1);
                orderMaster.setDistrict(1);
                orderMaster.setAddress(customerAddr.getAddress());
                this.orderMasterService.save(orderMaster);

                //3、get orderId for order detail
                Integer orderId = this.getOrderId(orderSn);

                //4、fill order detail
                BigDecimal factor = new BigDecimal("0.01");
                BigDecimal count = new BigDecimal(needContent.getNeedCount().toString());
                orderDetail.setOrderId(orderId);
                orderDetail.setContentId(needContent.getNeedContentId());
                orderDetail.setProductName(needContent.getNeedTitle());
                orderDetail.setProductCnt(needContent.getNeedCount());
                BigDecimal productPrice = (orderMaster.getPaymentMoney().divide(count)).setScale(2, BigDecimal.ROUND_HALF_UP);
                orderDetail.setProductPrice(productPrice);
                orderDetail.setAverageCost((productPrice.multiply(factor)).setScale(2, BigDecimal.ROUND_HALF_UP));
                this.orderDetailService.save(orderDetail);
                return true;
            } else {
                return false;

            }
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private CustomerInf getCustomerInf(Integer customerId) {
        QueryWrapper<CustomerInf> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerInf::getCustomerId, customerId);
        List<CustomerInf> list = this.customerInfService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    private CustomerAddr getCustomerAddr(Integer customerId) {
        QueryWrapper<CustomerAddr> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerAddr::getCustomerId, customerId);
        List<CustomerAddr> list = this.customerAddrService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    private Integer getOrderId(String orderSn) {
        QueryWrapper<OrderMaster> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(OrderMaster::getOrderSn, orderSn);
        List<OrderMaster> list = this.orderMasterService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0).getOrderId();
        }
    }
}
