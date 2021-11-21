package com.cloud.order;

import com.cloud.order.entity.CloudOrder;
import com.cloud.order.mapper.CloudOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CloudOrderApplicationTests {

    @Resource
    private CloudOrderMapper orderMapper;

    @Test
    void contextLoads() {
        CloudOrder cloudOrder = orderMapper.selectByPrimaryKey(1);
        System.out.println(cloudOrder);

    }

}
