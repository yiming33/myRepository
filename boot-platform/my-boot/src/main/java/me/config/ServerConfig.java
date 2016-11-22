package me.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by YiMing on 2016/11/7.
 * 读取资源文件
 */
@ConfigurationProperties(prefix = "server")
@Component
public class ServerConfig {
	private int port;
	private String contextPath;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}
