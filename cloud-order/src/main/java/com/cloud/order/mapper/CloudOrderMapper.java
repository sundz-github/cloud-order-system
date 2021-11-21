package com.cloud.order.mapper;


import com.cloud.order.entity.CloudOrder;

/**
 * (CloudOrder)表数据库访问层
 *
 * @author liushengbin
 * @since 2021-11-21 13:33:03
 */
public interface CloudOrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CloudOrder record);

    int insertSelective(CloudOrder record);

    CloudOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloudOrder record);

    int updateByPrimaryKey(CloudOrder record);
}