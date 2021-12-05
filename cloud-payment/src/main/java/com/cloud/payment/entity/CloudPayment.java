package com.cloud.payment.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CloudPayment implements Serializable {

    private Integer id;

    /*private Integer orderId;*/

    private Double amount;

    private Date insertTime;

    private Date updateTime;

}