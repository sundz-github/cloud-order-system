package com.cloud.order.controller;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.OrderVO;
import com.cloud.order.service.CloudOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String commit(@RequestBody @Validated OrderVO orderVO) {
        return orderService.commit(orderVO);
    }

    @GetMapping("{id}")
    public OrderInfoVO query(@PathVariable("id") Integer id) throws Exception{
        return orderService.query(id);
    }

    @GetMapping("eurekaInfo")
    public void eurekaInfo(){ orderService.eurekaInfo();
    }
}
