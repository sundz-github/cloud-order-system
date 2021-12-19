package com.cloud.order.fallback;

import com.cloud.common.entity.ScoreVO;
import com.cloud.order.feign.CloudScoreFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/12 21:26
 */
@Log4j2
@Component
public class CloudScoreFallBack implements CloudScoreFeign {

    @Override
    public ScoreVO query(Integer id) throws Exception {
        log.error("<--------------------积分服务查询熔断了-------------------->");
        return null;
    }

    @Override
    public Integer commit(ScoreVO scoreVO) {
        log.error("<--------------------积分服务提交熔断了-------------------->");
        return null;
    }
}
