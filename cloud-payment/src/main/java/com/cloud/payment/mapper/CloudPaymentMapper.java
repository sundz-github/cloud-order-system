package com.cloud.payment.mapper;


import com.cloud.payment.entity.CloudPayment;

public interface CloudPaymentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CloudPayment record);

    int insertSelective(CloudPayment record);

    CloudPayment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloudPayment record);

    int updateByPrimaryKey(CloudPayment record);
}