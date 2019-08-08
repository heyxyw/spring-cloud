package com.zhouq.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zhouq.credit.api.CreditApi;

@FeignClient(value = "credit-service")
public interface CreditService extends CreditApi {

}