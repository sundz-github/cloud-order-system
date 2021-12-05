package com.cloud.order.service;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.OrderVO;
import com.cloud.common.entity.PaymentVO;
import com.cloud.common.entity.ScoreVO;
import com.cloud.order.entity.CloudOrder;
import com.cloud.order.feign.CloudPaymentFeign;
import com.cloud.order.feign.CloudScoreFeign;
import com.cloud.order.mapper.CloudOrderMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@Log4j2
public class CloudOrderService {

    @Resource
    private CloudOrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CloudPaymentFeign paymentFeign;

    @Autowired
    CloudScoreFeign scoreFeign;

    private static final String PAYMENT_URL = /*"http://localhost:3031/payment/"*/ "http://cloud-payment/payment/";

    private static final String SCORE_URL = /*"http://localhost:4040/score/"*/"http://cloud-score/score/";


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
        // ResponseEntity<PaymentVO> paymentEntity = restTemplate.getForEntity(PAYMENT_URL+"{id}", PaymentVO.class, id);
        try {
            PaymentVO payment = paymentFeign.query(id);
            if (null != payment) {
                vo.setPaymentVO(payment);
            }
            // ResponseEntity<ScoreVO> scoreEntity = restTemplate.getForEntity(SCORE_URL+"{id}", ScoreVO.class, id);
            ScoreVO score = scoreFeign.query(id);
            if (null != score) {
                vo.setScoreVO(score);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return vo;
    }

}
