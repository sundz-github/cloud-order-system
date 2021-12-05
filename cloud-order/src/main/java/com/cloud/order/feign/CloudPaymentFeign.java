package com.cloud.order.feign;

import com.cloud.common.entity.PaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 21:48
 */
@FeignClient(value = "CLOUD-PAYMENT", path = "payment")
public interface CloudPaymentFeign {

    @GetMapping("{id}")
    PaymentVO query(@PathVariable("id") Integer id) throws Exception;

}