package com.orange.web.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("product_no")
    private String productNo;

    @TableField("name")
    private String name;

    @TableField("detail")
    private String detail;

    @TableField("date_created")
    private LocalDateTime dateCreated;

    @TableField("category")
    private String category;

    @TableField("status")
    private String status;

    @TableField("price")
    private Integer price;

    @TableField("classifier")
    private Integer classifier;

    @TableField("order_id")
    private Integer orderId;

    @TableField("description")
    private String description;

    @TableField("main_photo")
    private String mainPhoto;


}
