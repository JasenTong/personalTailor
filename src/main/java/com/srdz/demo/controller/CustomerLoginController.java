package com.srdz.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.srdz.demo.domain.CommonReturn;
import com.srdz.demo.domain.CustomerAddr;
import com.srdz.demo.domain.CustomerInf;
import com.srdz.demo.domain.CustomerLogin;
import com.srdz.demo.service.ICustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

    @Autowired
    private ICustomerLoginService customerLoginService;

    private static final String CHANGEPWD_SUCCESS = "修改密码成功！";

    private static final String CHANGEPWD_ERROR = "修改失败，检查手机号码是否正确！";


    CommonReturn commonReturn = new CommonReturn();

    @PostMapping("signUp")
    public ModelAndView customerSignUp(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        //1、customerLogin table
        CustomerLogin customerLogin = new CustomerLogin();
        CustomerInf customerInf = new CustomerInf();
        CustomerAddr customerAddr = new CustomerAddr();
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        customerLogin.setUserStatus(1);
        if (null != loginName && null != password) {
            customerLogin.setLoginName(loginName);
            customerLogin.setPassword(password);
        } else {
            mv.setViewName("/customer/login");
            mv.addObject(commonReturn.fail());
            return mv;
        }

        //2、customerInf table
        customerInf.setCustomerName(request.getParameter("customerName"));
        Date date = new Date();
        customerInf.setRegisterTime(date);
        customerInf.setBirthday(date);
        customerInf.setCustomerEmail(request.getParameter("customerEmail"));
        customerInf.setCustomerLevel(1);
        customerInf.setGender(request.getParameter("gender"));
        customerInf.setIdentityCardNo("100010100110");
        customerInf.setIdentityCardType(1);
        customerInf.setMobilePhone(request.getParameter("mobilePhone"));
        customerInf.setUserPoint(1);

        //3、customerAddress table
        //default not necessary
        customerAddr.setIsDefault(1);
        customerAddr.setProvince(1);
        customerAddr.setDistrict(1);
        customerAddr.setCity(1);
        customerAddr.setZip(request.getParameter("zip"));
        customerAddr.setAddress(request.getParameter("address"));

        //check firstly
        String checkRes = this.customerLoginService.SignUpCheck(customerLogin, customerInf);
        if (null == checkRes) {
            //pass sign up check
            boolean flag = this.customerLoginService.customerSignUp(customerLogin, customerInf, customerAddr);
            if (flag) {
                mv.addObject(commonReturn.success());
                mv.setViewName("/customer/login");
                return mv;
            } else {
                mv.addObject(commonReturn.fail());
                mv.setViewName("/customer/signUp");
                return mv;
            }
        } else {
            //do not pass sign up check
            mv.addObject(commonReturn.fail());
            mv.addObject(checkRes);
            mv.setViewName("/customer/signUp");
            return mv;
        }
    }

    @PostMapping("login")
    public ModelAndView login(CustomerLogin customerLogin, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        CustomerLogin customer = getCustomerLoginInfo(customerLogin);
        if (null == customer) {
            mv.addObject(this.commonReturn.fail());
            mv.setViewName("customer/login");
        } else {
            session.setAttribute("customer", customer);
            mv.addObject(this.commonReturn.success());
            mv.addObject("loginName", customer.getLoginName());
            mv.setViewName("index");
        }
        return mv;
    }

    /**
     * @param customerLogin query table of customerLogin
     * @return
     */
    private CustomerLogin getCustomerLoginInfo(CustomerLogin customerLogin) {
        QueryWrapper<CustomerLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(CustomerLogin::getLoginName, customerLogin.getLoginName())
                .eq(CustomerLogin::getPassword, customerLogin.getPassword());
        List<CustomerLogin> list = this.customerLoginService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @PostMapping("changePassword")
    public ModelAndView changePwd(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //1.get cutomer from session
        CustomerLogin customerLogin = (CustomerLogin) session.getAttribute("customer");
        //2.get information about password and mobile phone
        String pwd = request.getParameter("passwoerd");
        String mobilePhone = request.getParameter("mobilePhone");
        Boolean flag = this.customerLoginService.changePwd(customerLogin, pwd, mobilePhone);
        if (flag) {
            mv.addObject(CHANGEPWD_SUCCESS);
            return mv;
        } else {
            mv.addObject(CHANGEPWD_ERROR);
            return mv;
        }
    }

    @PostMapping("logOut")
    public ModelAndView logOut(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        request.getSession().invalidate();
        mv.setViewName("index");
        return mv;
    }
}
