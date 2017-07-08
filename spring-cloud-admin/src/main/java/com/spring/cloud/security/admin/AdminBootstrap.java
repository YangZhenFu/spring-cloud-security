package com.spring.cloud.security.admin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 服务层
 * @author yangzhenfu
 *
 */
//@EnableDiscoveryClient//激活eureka中的DiscoveryClient实现
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class AdminBootstrap {
	public static void main(String[] args) {
		new SpringApplicationBuilder(AdminBootstrap.class).web(true).run(args);
	}
}
