package com.cloud.score.mapper;


import com.cloud.score.entity.CloudScore;

public interface CloudScoreMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CloudScore record);

    int insertSelective(CloudScore record);

    CloudScore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloudScore record);

    int updateByPrimaryKey(CloudScore record);
}