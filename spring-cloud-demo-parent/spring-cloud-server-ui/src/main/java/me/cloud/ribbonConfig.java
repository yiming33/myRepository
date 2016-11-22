package me.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import me.cloud.annotation.ExcludeFromComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YiMing on 2016/11/19.
 */
@Configuration
@ExcludeFromComponent
public class ribbonConfig {

	/**
	 * ribbon随机访问规则（默认是轮询）
	 * 
	 * @return
	 */
//	@Bean
//	public IRule ribbonRule() {
//		return new RandomRule();
//	}
}
