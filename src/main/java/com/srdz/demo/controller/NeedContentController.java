package com.srdz.demo.controller;

import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.domain.DesignerLogin;
import com.srdz.demo.domain.NeedContent;
import com.srdz.demo.service.NewNeedContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/need")
public class NeedContentController {

    CommonReturn commonReturn = new CommonReturn();

    @Autowired
    private NewNeedContentService newNeedContentService;


    @GetMapping("content")
    public CommonReturn creatNeedContent(HttpServletRequest request, HttpSession session) {
        NeedContent needContent = new NeedContent();
        CustomerLogin customerLoginInf = (CustomerLogin) session.getAttribute("customer");
        DesignerLogin designerLogin = (DesignerLogin) session.getAttribute("designer");
        String title = request.getParameter("tittle");
        String content = request.getParameter("content");
        if (null == customerLoginInf) {
            return commonReturn.fail();
        }
        needContent.setCustomerId(customerLoginInf.getCustomerId());
        needContent.setDesignerId(designerLogin.getDesignerId());
        needContent.setNeedTitle(title);
        needContent.setContent(content);
        this.newNeedContentService.insertNeedContent(needContent);
        return commonReturn.success();
    }

    @GetMapping("plancontent")
    public CommonReturn createPlanContent(HttpServletRequest request, NeedContent needContent) {
        String planContent = request.getParameter("planContent");
        Double needMoney = Double.valueOf(request.getParameter("needMoney"));
        if (null != needContent && null != planContent && null != needMoney) {
            needContent.setPlanContent(planContent);
            needContent.setNeedMoney(needMoney);
            this.newNeedContentService.insertPlanContentByContnetId(needContent);
            return commonReturn.success();
        }else{
            return commonReturn.fail();
        }
    }
}
