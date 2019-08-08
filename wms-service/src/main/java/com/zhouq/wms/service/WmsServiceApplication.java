package com.zhouq.wms.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务A的启动类
 * @author zhonghuashishan
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class WmsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmsServiceApplication.class, args);
	}
	
}