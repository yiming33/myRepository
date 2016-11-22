package me.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YiMing on 2016/11/16.
 */
@RestController
@RequestMapping("/")
public class DemoController {

	@RequestMapping(value = "/getDemoMessage", method = RequestMethod.GET)
	public String getDemoMessage() {
		return "this is server1";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "hello world!";
	}

	@RequestMapping(value = "/getDemoMessageForFeign", method = RequestMethod.GET)
	public String getDemoMessageForFeign() {
		return "this is server1";
	}
}
