package me.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by YiMing on 2016/11/11.
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ThreadLocal<Long> startTime = new ThreadLocal<>();

	@Pointcut("execution(* me.controller..*.*(..))")
	public void webLog() {
	};

	@Before("webLog()")
	public void doLogBefore(JoinPoint joinPoint) {
		// startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		logger.info("WebLogAspect.doBefore()");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		// 获取所有参数方法一：
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			System.out.println(paraName + ": " + request.getParameter(paraName));
		}

	}

	@AfterReturning("webLog()")
	public void doLogAfterReturning(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		logger.info("WebLogAspect.doLogAfterReturning()");
		logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
				+ "方法执行耗时为：" + (System.currentTimeMillis() - startTime.get()));
	}
}
