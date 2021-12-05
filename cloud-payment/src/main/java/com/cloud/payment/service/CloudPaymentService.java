package com.cloud.payment.service;

import com.cloud.common.entity.PaymentVO;
import com.cloud.common.utils.RequestUtil;
import com.cloud.payment.entity.CloudPayment;
import com.cloud.payment.mapper.CloudPaymentMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:19
 */
@Service
@Log4j2
public class CloudPaymentService {

    @Resource
    private CloudPaymentMapper paymentMapper;

    /**
     *  支付提交
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
     * @param id
     * @return {@link PaymentVO}
     */
    public PaymentVO query(Integer id) throws Exception {
        log.info("支付服务ip信息:{}", InetAddress.getLocalHost().getHostAddress() + ":"+ RequestUtil.getReuqestPort());
        CloudPayment payment = paymentMapper.selectByPrimaryKey(id);
        if (null != payment) {
            PaymentVO vo = new PaymentVO();
            BeanUtils.copyProperties(payment, vo);
            return vo;
        }
        return null;
    }
}
