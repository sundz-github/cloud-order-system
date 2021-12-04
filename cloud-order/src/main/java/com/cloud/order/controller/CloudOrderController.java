package com.cloud.order.controller;

import com.cloud.common.entity.OrderVO;
import com.cloud.order.service.CloudOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 订单接口 </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:12
 */
@RestController
@RequestMapping("order")
public class CloudOrderController {

    @Autowired
    private CloudOrderService orderService;

    @PostMapping("commit")
    public String commit(@RequestBody OrderVO orderVO) {
        return orderService.commit(orderVO);
    }
}
