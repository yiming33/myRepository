package me.redis.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by YiMing on 2016/11/10. 开启基于redis的session共享
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60) // 一分钟失效时间
public class RedisSessionConfig {
}
