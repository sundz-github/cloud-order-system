package com.cloud.order.fallback;

import com.cloud.common.entity.PaymentVO;
import com.cloud.order.feign.CloudPaymentFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/12 21:24
 */
@Log4j2
@Component
public class CloudPaymentFallBack implements CloudPaymentFeign {

    @Override
    public PaymentVO query(Integer id) throws Exception {
        log.error("<--------------------支付服务查询熔断了-------------------->");
        return null;
    }

    @Override
    public Integer commit(PaymentVO paymentVO) {
        log.error("<--------------------支付服务提交熔断了-------------------->");
        return null;
    }
}
