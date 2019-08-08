package com.zhouq.inventory.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhouq.inventory.api.InventoryApi;

@RestController
public class InventoryService implements InventoryApi {

	public String deductStock(@PathVariable("productId") Long productId, 
			@PathVariable("stock") Long stock) {
		System.out.println("对商品【productId=" + productId + "】扣减库存：" + stock);    
		return "{'msg': 'success'}";
	}

}