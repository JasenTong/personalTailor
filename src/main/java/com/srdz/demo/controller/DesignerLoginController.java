package com.srdz.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.DesignerInf;
import com.srdz.demo.domain.DesignerLogin;
import com.srdz.demo.service.IDesignerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/designer")
public class DesignerLoginController {
    CommonReturn commonReturn = new CommonReturn();

    @Autowired
    private IDesignerLoginService designerLoginService;

    @GetMapping("signup")
    public CommonReturn DesignerSignUp(HttpServletRequest request) {
        DesignerLogin designerLogin = new DesignerLogin();
        DesignerInf designerInf = new DesignerInf();
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        if (null != loginName && null != password) {
            designerLogin.setLoginName(loginName);
            designerLogin.setPassword(password);
        } else {
            return commonReturn.fail();
        }
        designerInf.setDesignerName(request.getParameter("designerName"));
        Date date = new Date();
        designerInf.setRegisterTime(date);
        designerInf.setBirthday(date);
        designerInf.setDesignerEmail(request.getParameter("designerEmail"));
        designerInf.setDesignerLevel(1);
        designerInf.setGender(request.getParameter("gender"));
        //default not necessary
        designerInf.setIdentityCardNo("100010100110");
        designerInf.setIdentityCardType(1);
        designerInf.setMobilePhone(request.getParameter("mobilePhone"));
        designerInf.setUserPoint(1);
        this.designerLoginService.designerSignUp(designerLogin, designerInf);
        return commonReturn.success();


    }

    @GetMapping("login")
    public CommonReturn DesignerLogin(DesignerLogin designerLogin, HttpSession session) {
        if (null != designerLogin) {
            QueryWrapper<DesignerLogin> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda()
                    .eq(DesignerLogin::getLoginName, designerLogin.getLoginName())
                    .eq(DesignerLogin::getPassword, designerLogin.getPassword());
            List<DesignerLogin> list = this.designerLoginService.list(queryWrapper);
            if (CollectionUtils.isEmpty(list)) {
                return commonReturn.fail();
            } else {
                session.setAttribute("designer", list.get(0));
                return commonReturn.success();
            }
        }
        return commonReturn.success();
    }
}
