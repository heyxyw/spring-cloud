package com.zhouq.order.service;

import com.zhouq.pay_api.PayApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Create by zhouq on 2019/8/8
 */
@FeignClient(value = "pay-service")
public interface PayService extends PayApi {
}
