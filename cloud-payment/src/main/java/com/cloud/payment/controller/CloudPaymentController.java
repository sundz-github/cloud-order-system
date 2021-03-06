package com.cloud.payment.controller;

import com.cloud.common.entity.PaymentVO;
import com.cloud.payment.service.CloudPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:19
 */
@RestController
@RequestMapping("payment")
public class CloudPaymentController {

    @Autowired
    private CloudPaymentService paymentService;

    @PostMapping("commit")
    public Integer commit(@RequestBody @Validated PaymentVO paymentVO) {
        return paymentService.commit(paymentVO);
    }

    @GetMapping("{id}")
    public PaymentVO query(@PathVariable("id") Integer id, HttpServletRequest request) throws Exception {
        return paymentService.query(id, request.getLocalPort());
    }
}
