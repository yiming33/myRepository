package me.runload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by YiMing on 2016/11/7. 服务启动后加载
 */
@Component
@Order(1)   //加载顺序
public class RunLoad implements CommandLineRunner {

	@Override
	public void run(String... strings) throws Exception {

	}
}
