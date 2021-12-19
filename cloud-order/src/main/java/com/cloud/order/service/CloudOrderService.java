package com.cloud.order.service;

import com.cloud.common.entity.OrderInfoVO;
import com.cloud.common.entity.OrderVO;
import com.cloud.common.entity.PaymentVO;
import com.cloud.common.entity.ScoreVO;
import com.cloud.common.utils.RequestUtil;
import com.cloud.order.entity.CloudOrder;
import com.cloud.order.feign.CloudPaymentFeign;
import com.cloud.order.feign.CloudScoreFeign;
import com.cloud.order.mapper.CloudOrderMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

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
    private CloudScoreFeign scoreFeign;

    @Autowired
    private DiscoveryClient discoveryClient;


    private static final String PAYMENT_URL = /*"http://localhost:3031/payment/"*/ "http://cloud-payment/payment/";

    private static final String SCORE_URL = /*"http://localhost:4040/score/"*/"http://cloud-score/score/";


    /**
     * 订单提交
     *
     * @param orderVO
     * @return {@link String}
     */
    @Transactional(rollbackFor = Exception.class)
    public String commit(OrderVO orderVO) {
        CloudOrder insert = new CloudOrder();
        PaymentVO paymentVO = new PaymentVO();
        Double amount = orderVO.getAmount();
        paymentVO.setAmount(amount);
        Integer paymentId = paymentFeign.commit(paymentVO);
        ScoreVO scoreVO = new ScoreVO();
        scoreVO.setIsSuccess(1);
        // 积分 = 金额 * 10
        scoreVO.setScore(amount * 10);
        Integer scoreId = scoreFeign.commit(scoreVO);
        insert.setCustomer(orderVO.getCustomer());
        insert.setOrderNo("T" + DateFormatUtils.format(new Date(), "yyyy-MM-dd") + RandomStringUtils.randomNumeric(3));
        insert.setPaymentId(paymentId);
        insert.setGoods(orderVO.getGoods());
        insert.setScoreId(scoreId);
        orderMapper.insert(insert);
        return "操作成功,订单主键id:" + insert.getId();
    }


    /**
     * 查询
     *
     * @param id
     * @return {@link OrderInfoVO}
     */
    public OrderInfoVO query(Integer id) throws Exception{
        log.info("订单服务处理线程:{}", Thread.currentThread().getName());
        log.info("支付服务ip信息:{}", InetAddress.getLocalHost().getHostAddress() + ":" + RequestUtil.getReuqestPort());
        OrderInfoVO vo = new OrderInfoVO();
        CloudOrder cloudOrder = orderMapper.selectByPrimaryKey(id);
        if (null != cloudOrder) {
            BeanUtils.copyProperties(cloudOrder, vo);
            // ResponseEntity<PaymentVO> paymentEntity = restTemplate.getForEntity(PAYMENT_URL+"{id}", PaymentVO.class, id);
            try {
                PaymentVO payment = paymentFeign.query(cloudOrder.getPaymentId());
                if (null != payment) {
                    vo.setPaymentVO(payment);
                }
                // ResponseEntity<ScoreVO> scoreEntity = restTemplate.getForEntity(SCORE_URL+"{id}", ScoreVO.class, id);
                ScoreVO score = scoreFeign.query(cloudOrder.getScoreId());
                if (null != score) {
                    vo.setScoreVO(score);
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return vo;
    }

    public void eurekaInfo(){
        List<String> services = discoveryClient.getServices();
        log.info("services:{}", services);
    }

}
