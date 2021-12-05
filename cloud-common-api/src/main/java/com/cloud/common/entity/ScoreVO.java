package com.cloud.common.entity;

import lombok.Data;
import lombok.ToString;

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

    private Integer orderId;

    private Integer score;

    private Integer isSuccess;
}
