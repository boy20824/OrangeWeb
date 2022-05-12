package com.orange.web.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("amount")
    private Integer amount;

    @TableField("shipping_date")
    private LocalDateTime shippingDate;

    @TableField("product_id")
    private Integer productId;

    @TableField("product_no")
    private String productNo;

    @TableField("minimum")
    private Integer minimum;

    @TableField("period")
    private String period;


}
