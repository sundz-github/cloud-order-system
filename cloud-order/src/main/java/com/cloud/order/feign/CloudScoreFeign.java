package com.cloud.order.feign;

import com.cloud.common.entity.ScoreVO;
import com.cloud.order.configuration.FeignConfiguration;
import com.cloud.order.fallback.CloudScoreFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/5 12:49
 */
@FeignClient(value = "CLOUD-SCORE", path = "score", fallback = CloudScoreFallBack.class, configuration = FeignConfiguration.class)
public interface CloudScoreFeign {

    @GetMapping("{id}")
    ScoreVO query(@PathVariable("id") Integer id) throws Exception;

    @PostMapping("commit")
    Integer commit(@RequestBody @Validated ScoreVO scoreVO);
}
