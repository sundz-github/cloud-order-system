package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/11/26 21:14
 */
@Data
@ToString
public class ScoreVO {

    private Integer id;

    /*private Integer orderId;*/

    @NotNull(message = "积分不能为null")
    @PositiveOrZero(message = "积分必须为非负数")
    private Double score;

    private Integer isSuccess;
}
