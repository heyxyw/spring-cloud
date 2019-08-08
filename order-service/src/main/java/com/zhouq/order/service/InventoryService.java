package com.zhouq.order.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.zhouq.inventory.api.InventoryApi;

@FeignClient(value = "inventory-service")
public interface InventoryService extends InventoryApi {

}