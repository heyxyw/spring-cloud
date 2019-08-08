package com.zhouq.Pay.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhouq.pay_api.PayApi;

@RestController
public class PayService implements PayApi {

	public String pay(@PathVariable("orderId") Long orderId) {
		System.out.println("对订单进行支付【orderId=" + orderId + "】");
		return "{'msg': 'success'}";
	}
	
}