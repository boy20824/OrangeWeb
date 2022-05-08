package com.orange.shop.controller;


import com.orange.shop.vo.R;
import com.orange.shop.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/register")
    public R registerMember(@Validated RegisterVo registerVo, BindingResult bindingResult) {
        log.info("表單傳入訊息: {}", registerVo);
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            log.info("表單驗證錯誤: {}", error);
            return R.unprocessableEntity(error);
        }
        return R.created("成功註冊!!");
    }

}
