package me.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by YiMing on 2016/11/16.
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
