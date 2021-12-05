package com.cloud.score.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CloudScore implements Serializable {

    private Integer id;

    /*private Integer orderId;*/

    private Double score;

    private Integer isSuccess;

    private Date insertTime;

    private Date updateTime;

}