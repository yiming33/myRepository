package me.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by YiMing on 2016/11/16.
 */
@RestController
@RequestMapping("/")
public class DemoController {

	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping(value = "/getDemoMessage", method = RequestMethod.GET)
	public String getDemoMessage() {
		return "this is server2";
	}

	@RequestMapping(value = "/getDemoMessageForFeign", method = RequestMethod.GET)
	public String getDemoMessageForFeign() {
		return "this is server2";
	}

	@GetMapping("/getMyServer01")
	public String getMyServer01() {
		return restTemplate.getForObject("http://myServer01/getDemoMessage", String.class);
	}
}
