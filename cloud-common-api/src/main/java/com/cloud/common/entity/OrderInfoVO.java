package com.cloud.common.entity;

import lombok.Data;

/**
 * <p> 订单详情 </p>
 *
 * @author Sundz
 * @date 2021/12/4 21:19
 */
@Data
public class OrderInfoVO {

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

    private PaymentVO paymentVO;

    private ScoreVO scoreVO;

}
