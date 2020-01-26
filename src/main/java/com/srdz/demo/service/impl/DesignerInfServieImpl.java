package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.DesignerInf;
import com.srdz.demo.mapper.DesignerInfMapper;
import com.srdz.demo.service.IDesignerInfService;
import org.springframework.stereotype.Service;

@Service
public class DesignerInfServieImpl extends ServiceImpl<DesignerInfMapper, DesignerInf>implements IDesignerInfService {
}
