package com.srdz.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.DesignerInf;
import com.srdz.demo.domain.DesignerLogin;
import com.srdz.demo.mapper.DesignerLoginMapper;
import com.srdz.demo.service.IDesignerInfService;
import com.srdz.demo.service.IDesignerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DesignerLoginServiceImpl extends ServiceImpl<DesignerLoginMapper, DesignerLogin> implements IDesignerLoginService {

    CommonReturn commonReturn = new CommonReturn();

    @Autowired
    private IDesignerLoginService designerLoginService;
    @Autowired
    private IDesignerInfService designerInfService;

    public Integer getDesignerId(DesignerLogin designerLogin) {
        QueryWrapper<DesignerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(DesignerLogin::getLoginName, designerLogin.getLoginName())
                .eq(DesignerLogin::getPassword, designerLogin.getPassword());
        List<DesignerLogin> list = this.designerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0).getDesignerId();
        }
    }

    @Transactional
    public Boolean designerSignUp(DesignerLogin designerLogin, DesignerInf designerInf) {
        if (null != designerLogin && null != designerInf) {
            //1、insert designerLogin to designerLogin table
            this.designerLoginService.save(designerLogin);
            //2、get the designerId for designerInf
            Integer designerId = this.designerLoginService.getDesignerId(designerLogin);
            designerInf.setDesignerId(designerId);
            //3、insert designerInf to designerInf table
            this.designerInfService.save(designerInf);
            return true;
        } else {
            return false;
        }
    }
}
