package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/11/26 20:39
 */
@Data
@ToString
public class PaymentVO {

    private Integer id;

    private Integer orderId;

    private Double amount;

}
