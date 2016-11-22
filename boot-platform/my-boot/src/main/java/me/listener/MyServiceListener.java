package me.listener;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by YiMing on 2016/11/2.
 * ServletContext监听器（Listener）
 */
@WebListener
public class MyServiceListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext 销毁");
    }
}
