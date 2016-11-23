package me.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by YiMing on 2016/11/16.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
//    111
	public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class,args);
    }
}
