package com.cloud.order;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.utils.RequestUtil;
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


}
