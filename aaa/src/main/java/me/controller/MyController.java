package me.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YiMing on 2016/11/14.
 */
@RestController
@RequestMapping("/")
public class MyController {

	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}

}
