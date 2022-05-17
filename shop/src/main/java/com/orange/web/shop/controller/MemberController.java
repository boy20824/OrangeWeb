package com.orange.web.shop.controller;


import com.orange.web.shop.model.Member;
import com.orange.web.shop.service.IMemberService;
import com.orange.web.shop.vo.LoginVo;
import com.orange.web.shop.vo.R;
import com.orange.web.shop.vo.RegisterVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
@Api(tags = "會員相關Api")
@RestController
@RequestMapping("/shop/member")
@Slf4j
public class MemberController {

    @Resource
    IMemberService iMemberService;

    @ApiOperation(value = "會員註冊Api", httpMethod = "POST", notes = "會員註冊請呼叫此方法")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "信箱" +
                    "\n1.@前後只接受 英文字母 (a-z;A-Z) 數字 _ - ." +
                    "\n2.不接受全形文字", required = true),
            @ApiImplicitParam(name = "pwd", value = "密碼" +
                    "\n1.字數限制：6-12個位元" +
                    "\n2.只能輸入英文字母 (a-z;A-Z)、數字，不接受全形文字" +
                    "\n3.英文字母大小寫視為不同的字母" +
                    "\n4.密碼必含一個英文和一個數字，大小寫不同", required = true),
            @ApiImplicitParam(name = "name", value = "姓名" +
                    "\n1.可輸入外國文字" +
                    "\n2.字數限制：20字" +
                    "\n3.符號只接受 「」- . ()" +
                    "\n4.不接受 4byte以上的字及表情符號", required = true),
            @ApiImplicitParam(name = "phoneNumber", value = "電話" +
                    "\n1.限填數字和1個「＋」， 「＋」需在開頭" +
                    "\n2.不含+最少10位數，最長15字", required = true),
            @ApiImplicitParam(name = "address", value = "地址", required = true),
            @ApiImplicitParam(name = "account", value = "帳號", required = true),
            @ApiImplicitParam(name = "birthday", value = "生日"),
            @ApiImplicitParam(name = "gender", value = "性別"),
            @ApiImplicitParam(name = "loginType", value = "註冊方式" +
                    "\n orange/instagram/facebook"),
    })
    public R registerMember(@Validated RegisterVo registerVo, BindingResult bindingResult) {
        log.info("表單傳入訊息: {}", registerVo);
        //表單參數進行驗證
        if (bindingResult.hasErrors()) {
            String error = bindingResult.getFieldError().getDefaultMessage();
            log.info("表單驗證錯誤: {}", error);
            return R.unprocessableEntity(error);
        }
        String verify = verifyRegisterVo(registerVo);

        if (verify != null) {
            return R.invalidRequest(verify);
        }

        iMemberService.registerMember(registerVo);

        return R.created("成功註冊!!");
    }

    private String verifyRegisterVo(RegisterVo registerVo) {

        if (!verifyPwd(registerVo.getPwd())) {
            return "密碼含有全形字符";
        }

        if (!verifyNameForEmoji(registerVo.getName())) {
            return "姓名還有表情符號";
        }

        if (!verifyNameFor4Byte(registerVo.getName())) {
            return "姓名字型大於4Byte";
        }

        if (!verifyPhoneNumber(registerVo.getPhoneNumber())) {
            return "電話號碼+需在開頭";
        }
        return null;
    }

    //驗證密碼是否有全形文字
    private boolean verifyPwd(String pwd) {

        char[] str = pwd.toCharArray();
        for (int i = 0; i < str.length; i++) {
            //獲取當前字元的unicode編碼
            int code = str[i];
            if (code >= 65281 && code <= 65373) {
                return false;
            }
        }
        return true;
    }

    //驗證表情符號
    private boolean verifyNameForEmoji(String name) {
        if (name != null) {
            Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(name);
            if (emojiMatcher.find()) {
                return false;
            }
        }
        return true;
    }

    //驗證字型大於4Byte
    private boolean verifyNameFor4Byte(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.substring(i, i + 1).getBytes().length > 4) {
                return false;
            }
        }
        return true;
    }

    //驗證第一碼之後出現"+"
    private boolean verifyPhoneNumber(String phoneNumber) {
        if (phoneNumber.substring(1, phoneNumber.length()).contains("+")) {
            return false;
        }
        return true;
    }
    
    @PostMapping("/accountCheck")
    private R verifyAccount(@Validated LoginVo loginVo, BindingResult bindingResult) {
    	Member member = new Member();
    	String error = "";
    	log.info("登入表單傳入訊息：{}", loginVo);
        if (bindingResult.hasErrors()) {
        	error = bindingResult.getFieldError().getDefaultMessage();
            log.info("表單驗證錯誤：{}", error);
            return R.unprocessableEntity(error);
        }else {
        	member = iMemberService.getMemberByEmail(loginVo.getEmail());
        	if(member == null) { //無此帳號Email
        		error = "使用者查詢失敗，查無使用者Email";
        		log.info(error + "：{}", loginVo.getEmail());
        		return R.unauthorized(error);
        	}else { //有此帳號Email
        		return R.ok("OK");
        	}
        }
    }

}
