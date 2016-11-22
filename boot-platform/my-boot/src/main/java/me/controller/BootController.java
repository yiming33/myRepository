package me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by YiMing on 2016/10/28.
 */
@Controller
@RequestMapping("/test2")
public class BootController {

	@RequestMapping("/aa")
	public String thymeleafTest(Map<String, Object> map) {
		map.put("hello", "h哈哈哈哈");
		return "/demo/helloHtml";
	}

}
