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
    @Pattern(regexp = "^\\d{10,15}$",message = "電話號碼不符合規則!")
    @Size(max=16,min=11)
    private Integer phoneNumber;

    @NotBlank(message = "帳號不能為空!")
    private String account;

    @NotBlank(message = "密碼不能為空!")
    @Size(max=12,min=6)
    private String pwd;

    @NotBlank(message = "地址不能為空!")
    private String address;

    @NotBlank(message = "郵件信箱不能為空!")
    private String email;

    @NotBlank(message = "姓名不能為空!")
    @Pattern(regexp = "^+\\d{10}$",message = "姓名不符合規則!")
    @Max(20)
    private String name;

    private String gender;

    private LocalDate birthday;

    private LocalDateTime dateCreated;
}
