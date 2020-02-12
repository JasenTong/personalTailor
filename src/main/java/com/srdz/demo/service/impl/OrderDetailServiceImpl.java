package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.OrderDetail;
import com.srdz.demo.mapper.OrderDetailMapper;
import com.srdz.demo.service.IOrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
}
