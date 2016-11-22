package me.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.cloud.service.CloudDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2016/11/19.
 */
@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CloudDemoService cloudDemoService;

	@GetMapping("getServersMessage")
	@HystrixCommand(fallbackMethod = "getServersMessageFallback")
	public String getServersMessage() {
		return restTemplate.getForObject("http://myServers/getDemoMessage", String.class);
	}

	public String getServersMessageFallback() {
		return "this is fallback";
	}

	@GetMapping("getDemoMessageForFeign")
	public String getDemoMessageForFeign() {
		return cloudDemoService.getMessage();
	}
}
