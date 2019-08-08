package com.zhouq.pay_api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/pay")
public interface PayApi {

	@RequestMapping(value = "/pay/{orderId}", method = RequestMethod.PUT)
	String pay(@PathVariable("orderId") Long orderId);
	
}
