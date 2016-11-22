package me.cloud.service;

import me.cloud.fallback.CloudDemoServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by YiMing on 2016/11/17.
 */
@FeignClient(value = "myServers", fallback = CloudDemoServiceFallBack.class)
public interface CloudDemoService {

	@RequestMapping(value = "/getDemoMessageForFeign", method = RequestMethod.GET)
	String getMessage();
}
