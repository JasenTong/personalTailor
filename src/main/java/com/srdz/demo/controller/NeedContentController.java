package com.srdz.demo.controller;

import com.srdz.demo.domain.*;
import com.srdz.demo.service.NewNeedContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@RestController
@RequestMapping("/need")
public class NeedContentController {

    CommonReturn commonReturn = new CommonReturn();

    @Autowired
    private NewNeedContentService newNeedContentService;

    /**
     * generator needing content
     *
     * @param request
     * @param session
     * @return
     */
    @GetMapping("content")
    public CommonReturn creatNeedContent(HttpServletRequest request, HttpSession session) {
        NeedContent needContent = new NeedContent();
        CustomerLogin customerLoginInf = (CustomerLogin) session.getAttribute("customer");
        DesignerLogin designerLogin = (DesignerLogin) session.getAttribute("designer");
        String title = request.getParameter("tittle");
        String content = request.getParameter("content");
        Integer needCount = Integer.parseInt(request.getParameter("needCount"));
        if (null == customerLoginInf) {
            return commonReturn.fail();
        }
        needContent.setCustomerId(customerLoginInf.getCustomerId());
        needContent.setDesignerId(designerLogin.getDesignerId());
        needContent.setNeedTitle(title);
        needContent.setContent(content);
        needContent.setNeedCount(needCount);
        this.newNeedContentService.insertNeedContent(needContent);
        return commonReturn.success();
    }

    /**
     * fill the plan content
     *
     * @param request
     * @param needContent
     * @return
     */
    @GetMapping("plancontent")
    public CommonReturn createPlanContent(HttpServletRequest request, NeedContent needContent) {
        String planContent = request.getParameter("planContent");
        Double needMoney = Double.valueOf(request.getParameter("needMoney"));
        if (null != needContent && null != planContent && null != needMoney) {
            needContent.setPlanContent(planContent);
            needContent.setNeedMoney(needMoney);
            this.newNeedContentService.insertPlanContentByContnetId(needContent);
            return commonReturn.success();
        } else {
            return commonReturn.fail();
        }
    }

    /**
     * generator orderMaster and detail
     *
     * @param request
     * @param needContent
     * @return
     * @throws Exception
     */
    @GetMapping("confirm")
    public CommonReturn confirmPay(HttpServletRequest request, NeedContent needContent) throws Exception {
        try {
            OrderMaster orderMaster = new OrderMaster();
            //get pay method and pay money
            Integer wayPay = Integer.parseInt(request.getParameter("pay"));
            BigDecimal payMoney = new BigDecimal(request.getParameter("payMoney"));
            orderMaster.setPaymentMethod(wayPay);
            orderMaster.setPaymentMoney(payMoney);
            orderMaster.setOrderMoney(payMoney);
            Boolean flag = this.newNeedContentService.confirm(orderMaster, needContent);
            if (flag) {
                return commonReturn.success();
            } else {
                return commonReturn.fail();
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
