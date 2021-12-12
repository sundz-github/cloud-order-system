package com.cloud.payment.service;

import com.cloud.common.entity.PaymentVO;
import com.cloud.common.utils.RequestUtil;
import com.cloud.payment.entity.CloudPayment;
import com.cloud.payment.mapper.CloudPaymentMapper;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:19
 */
@Service
@Log4j2
// Hystrix统一降级处理
@DefaultProperties(defaultFallback = "gloableFallBack")
public class CloudPaymentService {

    @Resource
    private CloudPaymentMapper paymentMapper;

    /**
     * 支付提交
     *
     * @param paymentVO
     * @return {@link String}
     */
    public Integer commit(PaymentVO paymentVO) {
        CloudPayment insert = new CloudPayment();
        BeanUtils.copyProperties(paymentVO, insert);
        paymentMapper.insert(insert);
        return insert.getId();
    }

    /**
     * 查询
     *
     * @param id
     * @return {@link PaymentVO}
     */
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.timeout.enabled", value = "true"),  // 执行是否启用超时，默认启用true
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), // 命令执行超时时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),  // 一个rolling window内最小的请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"), // 触发断路的时间值 超过这个时间关闭断路器
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")}  // 错误比率阀值，如果错误率>=该值，circuit会被打开
            , fallbackMethod = "fallbackMethodQuery")
    public PaymentVO query(Integer id) throws Exception {
        log.info("支付服务处理线程:{}", Thread.currentThread().getName());
        log.info("支付服务ip信息:{}", InetAddress.getLocalHost().getHostAddress() + ":" + RequestUtil.getReuqestPort());
        // 故意超时
        TimeUnit.SECONDS.sleep(3);
        CloudPayment payment = paymentMapper.selectByPrimaryKey(id);
        if (null != payment) {
            PaymentVO vo = new PaymentVO();
            BeanUtils.copyProperties(payment, vo);
            return vo;
        }
        return null;
    }

    private PaymentVO fallbackMethodQuery(Integer id) {
        log.error("<-----------支付服务查询接口熔断了----------->id:{}", id);
        return null;
    }

    // eg：方法不能有参数
    private PaymentVO gloableFallBack(){
        log.error("<-----------支付服务统一降级处理----------->");
        return null;
    }
}
