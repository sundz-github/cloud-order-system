package com.cloud.order;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.PaymentVO;
import com.cloud.common.utils.RequestUtil;
import com.cloud.order.feign.CloudPaymentFeign;
import com.cloud.order.feign.CloudScoreFeign;
import com.cloud.order.mapper.CloudOrderMapper;
import com.cloud.order.service.CloudOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.InetAddress;

@SpringBootTest
class CloudOrderApplicationTests {

    @Resource
    private CloudOrderMapper orderMapper;

    @Autowired
    private CloudOrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CloudPaymentFeign paymentFeign;

    @Autowired
    private CloudScoreFeign scoreFeign;

    private static final String PAYMENT_URL = "http://localhost:3031/payment/";

    @Test
    public void queryTest() {
        OrderInfoVO query = orderService.query(1);
        System.out.println(query);
    }

    @Test
    public void redisTempleteTest() throws Exception {
        System.out.println(InetAddress.getLocalHost().getHostAddress() + ":"+RequestUtil.getReuqestPort());
    }

    @Test
    public void feignTest() throws Exception{
        /*ScoreVO vo = new ScoreVO();
        vo.setScore(100.0);
        vo.setIsSuccess(1);
        System.out.println(scoreFeign.commit(vo));*/
        PaymentVO vo = new PaymentVO();
        vo.setAmount(1000.0);
        System.out.println(paymentFeign.commit(vo));
    }


}
