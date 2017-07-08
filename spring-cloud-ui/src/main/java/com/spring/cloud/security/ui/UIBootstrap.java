package com.spring.cloud.security.ui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/**
 * 前端UI展示层
 * @author yangzhenfu
 *
 */
@SpringBootApplication
public class UIBootstrap {
	public static void main(String[] args) {
		new SpringApplicationBuilder(UIBootstrap.class).web(true).run(args);
	}
}
