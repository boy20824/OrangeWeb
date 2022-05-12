package com.orange.web.shop.controller;


import com.orange.web.shop.service.IMemberService;
import com.orange.web.shop.vo.R;
import com.orange.web.shop.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
@RestController
@RequestMapping("/shop/member")
@Slf4j
public class MemberController {

    @Resource
    IMemberService iMemberService;

    @PostMapping("/register")
    public R registerMember(@Validated RegisterVo registerVo, BindingResult bindingResult) {
        log.info("表單傳入訊息: {}", registerVo);
        //表單參數進行驗證
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            log.info("表單驗證錯誤: {}", error);
            return R.unprocessableEntity(error);
        }

        verifyRegisterVo(registerVo);

        return R.created("成功註冊!!");
    }

    private Object verifyRegisterVo(RegisterVo registerVo){

        if(!verifyEmail(registerVo.getEmail())){

        }

        if(!verifyPwd(registerVo.getPwd())){

        }

        if(!verifyName(registerVo.getName())){

        }

        if(!verifyPhoneNumber(registerVo.getPhoneNumber())){

        }


        return null;
    }

    private boolean verifyEmail(String email){

        return false;
    }

    private boolean verifyPwd(String pwd){

        return false;
    }

    private boolean verifyName(String name){

        return false;
    }

    private boolean verifyPhoneNumber(String phoneNumber){

        return false;
    }

}
