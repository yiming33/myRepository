package me.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by YiMing on 2016/11/2.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("session已创建" + httpSessionEvent.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("session销毁" + httpSessionEvent.getSession().getCreationTime());
	}
}
