package com.zhouq.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zhouq.wms_api.WmsApi;

@FeignClient(value = "wms-service")
public interface WmsService extends WmsApi {

}