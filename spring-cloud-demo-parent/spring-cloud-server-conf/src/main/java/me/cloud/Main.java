package me.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by YiMing on 2016/11/17.
 */
@SpringBootApplication
@EnableConfigServer // 开启配置服务器的支持
//@EnableEurekaClient // 开启作为Eureka Server客户端的支持
public class Main {
	public static void main(String[] args) {
		System.out.println(11);
		SpringApplication.run(Main.class, args);
	}
}
