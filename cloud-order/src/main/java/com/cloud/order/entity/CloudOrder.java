package com.cloud.order.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (CloudOrder)表实体类
 *
 * @author liushengbin
 * @since 2021-11-21 13:33:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CloudOrder implements Serializable {

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

    /**
     * 插入时间
     */

    private Date insertTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}