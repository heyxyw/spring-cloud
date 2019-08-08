package com.zhouq.pay.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhouq on 2019/8/8
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String greeting(
            @RequestParam("orderId") Long orderId) {
        System.out.println("支付订单:" + orderId);
        return "success";
    }
}
