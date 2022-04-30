package com.orange.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author John
 * @since 2022-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("order_no")
    private String orderNo;

    @TableField("member_id")
    private Integer memberId;

    @TableField("date_created")
    private LocalDateTime dateCreated;

    @TableField("status")
    private String status;

    @TableField("date_cancelled")
    private LocalDateTime dateCancelled;

    @TableField("payment_type")
    private String paymentType;

    @TableField("order_note")
    private String orderNote;

    @TableField("shopping_date")
    private LocalDate shoppingDate;

    @TableField("shopping_way")
    private String shoppingWay;

    @TableField("company_name")
    private String companyName;

    @TableField("tax_id")
    private Integer taxId;

    @TableField("merchant_note")
    private String merchantNote;


}
