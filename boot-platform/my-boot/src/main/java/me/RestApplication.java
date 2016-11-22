package me;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import me.config.YiMingConfig;
import me.interseptor.MyInterceptor;
import me.redis.conf.RedisCacheConfig;
import me.redis.conf.RedisSessionConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;
import java.util.List;

/**
 * Created by YiMing on 2016/10/28.
 */
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
@ServletComponentScan
@Import({ RedisCacheConfig.class, RedisSessionConfig.class ,})
@MapperScan("me.**.repository")
@ComponentScan(basePackages = "me")
@EnableConfigurationProperties({ YiMingConfig.class })
@EnableAutoConfiguration()
public class RestApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);
	}

	/**
	 * 添加拦截器
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/test2/**");
		super.addInterceptors(registry);
	}

	/**
	 * 请求返回json格式 fastjson
	 * 
	 * @return
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		super.configureMessageConverters(converters);

		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);

		converters.add(fastConverter);
	}

	@Scheduled(cron = "0/1000 * * * * ?") // 每20秒执行一次
	public void scheduler() {
		System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
	}

	/**
	 * 文件上传配置
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("50MB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("300MB");
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}
}
