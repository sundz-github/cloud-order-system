package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

/**
 * <p> 订单详情 </p>
 *
 * @author Sundz
 * @date 2021/12/4 21:19
 */
@Data
@ToString
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

    /**
     * 支付信息
     */
    private PaymentVO paymentVO;

    /**
     * 分数
     */
    private ScoreVO scoreVO;

}
