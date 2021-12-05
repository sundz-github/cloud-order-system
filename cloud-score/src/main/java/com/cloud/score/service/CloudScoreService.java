package com.cloud.score.service;

import com.cloud.common.entity.ScoreVO;
import com.cloud.common.utils.RequestUtil;
import com.cloud.score.entity.CloudScore;
import com.cloud.score.mapper.CloudScoreMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:26
 */
@Service
@Log4j2
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

    /**
     * 查询
     * @param id
     * @return {@link ScoreVO}
     */
    public ScoreVO query(Integer id) throws Exception{
        log.info("积分服务ip信息:{}", InetAddress.getLocalHost().getHostAddress() + ":"+ RequestUtil.getReuqestPort());
        CloudScore cloudScore = scoreMapper.selectByPrimaryKey(id);
        if (null != cloudScore) {
            ScoreVO vo = new ScoreVO();
            BeanUtils.copyProperties(cloudScore, vo);
            return vo;
        }
        return null;
    }

}
