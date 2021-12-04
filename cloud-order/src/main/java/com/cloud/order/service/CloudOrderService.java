package com.cloud.order.service;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.OrderVO;
import com.cloud.order.entity.CloudOrder;
import com.cloud.order.mapper.CloudOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:15
 */
@Service
public class CloudOrderService {

    @Resource
    private CloudOrderMapper orderMapper;



    /**
     *  订单提交
     * @param orderVO
     * @return {@link String}
     */
    public String commit(OrderVO orderVO) {
        CloudOrder insert = new CloudOrder();
        BeanUtils.copyProperties(orderVO, insert);
        orderMapper.insert(insert);
        return "操作成功,订单主键id:" + insert.getId();
    }


}
