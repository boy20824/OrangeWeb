package com.orange.web.shop.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LoginVo implements Serializable {

	private static final long serialVersionUID = 3383749201722007585L;

	@NotBlank(message = "郵件信箱不能為空!")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "郵件信箱不符合規則!")
    private String email;
	
    @NotBlank(message = "密碼不能為空!")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$",message = "密碼不符合規則!")
    private String pwd;

}
