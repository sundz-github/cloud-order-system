package com.cloud.score.service;

import com.cloud.common.entity.ScoreVO;
import com.cloud.score.entity.CloudScore;
import com.cloud.score.mapper.CloudScoreMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:26
 */
@Service
public class CloudScoreService {

    @Resource
    private CloudScoreMapper scoreMapper;
    /**
     *  支付提交
     * @param scoreVO
     * @return {@link String}
     */
    public Integer commit(ScoreVO scoreVO) {
        CloudScore insert = new CloudScore();
        BeanUtils.copyProperties(scoreVO, insert);
        scoreMapper.insert(insert);
        return insert.getId();
    }
}
