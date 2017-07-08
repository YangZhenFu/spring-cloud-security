package com.spring.cloud.security.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关负载中心，统一请求入口
 * @author yangzhenfu
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GateBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(GateBootstrap.class, args);
	}
}
