package com.cloud.order.service;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.OrderVO;
import com.cloud.common.entity.PaymentVO;
import com.cloud.common.entity.ScoreVO;
import com.cloud.order.entity.CloudOrder;
import com.cloud.order.mapper.CloudOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://localhost:3030";

    private static final String SCORE_URL = "http://localhost:4040";


    /**
     * 订单提交
     *
     * @param orderVO
     * @return {@link String}
     */
    public String commit(OrderVO orderVO) {
        CloudOrder insert = new CloudOrder();
        BeanUtils.copyProperties(orderVO, insert);
        orderMapper.insert(insert);
        return "操作成功,订单主键id:" + insert.getId();
    }


    /**
     * 查询
     *
     * @param id
     * @return {@link OrderInfoVO}
     */
    public OrderInfoVO query(Integer id) {
        OrderInfoVO vo = new OrderInfoVO();
        CloudOrder cloudOrder = orderMapper.selectByPrimaryKey(id);
        if (null != cloudOrder) {
            BeanUtils.copyProperties(cloudOrder, vo);
        }
        ResponseEntity<PaymentVO> paymentEntity = restTemplate.getForEntity(PAYMENT_URL, PaymentVO.class, id);
        if (paymentEntity.getStatusCode() == HttpStatus.OK) {
            vo.setPaymentVO(paymentEntity.getBody());
        }
        ResponseEntity<ScoreVO> scoreEntity = restTemplate.getForEntity(SCORE_URL, ScoreVO.class, id);
        if (HttpStatus.OK == scoreEntity.getStatusCode()) {
            vo.setScoreVO(scoreEntity.getBody());
        }
        return vo;
    }

}
