package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * <p> 订单 </p>
 *
 * @author Sundz
 * @date 2021/11/21 19:19
 */
@Data
@ToString
public class OrderVO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户
     */
    @NotBlank(message = "用户姓名不能为空")
    private String customer;

    /**
     * 商品描述
     */
    @NotBlank(message = "商品信息不能为空")
    private String goods;

    /**
     * 支付金额
     */
    @NotNull(message = "商品金额不能为null")
    @PositiveOrZero(message = "商品金额必须为非负数")
    private Double amount;

}
