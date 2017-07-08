package com.spring.cloud.security.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * 监控中心
 * @author yangzhenfu
 *
 */
@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableAdminServer
public class MonitorBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(MonitorBootstrap.class, args);
	}
	
	@Bean
	public HystrixCommandAspect hystrixAspect(){
		return new HystrixCommandAspect();
	}
}
