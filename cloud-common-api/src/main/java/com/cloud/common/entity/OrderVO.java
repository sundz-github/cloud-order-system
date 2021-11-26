package com.cloud.common.entity;

import lombok.Data;

/**
 * <p> 订单 </p>
 *
 * @author Sundz
 * @date 2021/11/21 19:19
 */
@Data
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
    private String customer;

    /**
     * 商品描述
     */
    private String goods;

    /**
     * 支付主键
     */
    private Integer paymentId;

    /**
     * 积分主键
     */
    private Integer scoreId;

}
