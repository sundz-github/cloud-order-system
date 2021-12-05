package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

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

    /*private Integer orderId;*/
    @NotNull(message = "金额不能为null")
    @PositiveOrZero(message = "金额必须为非负数")
    private Double amount;

}
