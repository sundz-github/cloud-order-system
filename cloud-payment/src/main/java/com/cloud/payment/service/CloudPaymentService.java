package com.cloud.payment.service;

import com.cloud.common.entity.OrderVO;
import com.cloud.common.entity.PaymentVO;
import com.cloud.payment.entity.CloudPayment;
import com.cloud.payment.mapper.CloudPaymentMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:19
 */
@Service
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
    public PaymentVO query(Integer id) {
        CloudPayment payment = paymentMapper.selectByPrimaryKey(id);
        if (null != payment) {
            PaymentVO vo = new PaymentVO();
            BeanUtils.copyProperties(payment, vo);
            return vo;
        }
        return null;
    }
}
