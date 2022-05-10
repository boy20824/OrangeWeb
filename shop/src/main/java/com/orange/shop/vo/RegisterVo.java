package com.orange.shop.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RegisterVo implements Serializable {

    private String memberNo;

    @NotBlank(message = "電話號號碼不能為空!")
    @Size(max=16,min=11)
    private String phoneNumber;

    @NotBlank(message = "帳號不能為空!")
    private String account;

    @NotBlank(message = "密碼不能為空!")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$",message = "密碼不符合規則!")
    private String pwd;

    @NotBlank(message = "地址不能為空!")
    private String address;

    @NotBlank(message = "郵件信箱不能為空!")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$",message = "郵件信箱不符合規則!")
    private String email;

    @NotBlank(message = "姓名不能為空!")
    @Max(20)
    private String name;

    private String gender;

    private LocalDate birthday;

    private LocalDateTime dateCreated;
}
