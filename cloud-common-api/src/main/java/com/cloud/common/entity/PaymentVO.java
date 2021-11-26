package com.cloud.common.entity;

import lombok.Data;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/11/26 20:39
 */
@Data
public class PaymentVO {

    private Integer id;

    private Integer orderId;

    private Double amount;

}
