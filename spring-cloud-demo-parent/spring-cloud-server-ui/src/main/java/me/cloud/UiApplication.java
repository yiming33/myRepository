package me.cloud;

import me.cloud.annotation.ExcludeFromComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2016/11/17.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "myServers1", configuration = ribbonConfig.class) // 对某个（些）服务采用该配置方法做负载均衡
@EnableFeignClients // 开启feign客户端支持
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponent.class) }) // 排除包含ExcludeFromComponent注解的类

@EnableCircuitBreaker // 开启CircuitBreaker支持
// @EnableZuulProxy // 开启网关代理的支持
public class UiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
