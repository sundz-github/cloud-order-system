package com.cloud.order.feign;

import com.cloud.common.entity.ScoreVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/5 12:49
 */
@FeignClient(value = "CLOUD-SCORE", path = "score")
public interface CloudScoreFeign {

    @GetMapping("{id}")
    ScoreVO query(@PathVariable("id") Integer id) throws Exception;
}