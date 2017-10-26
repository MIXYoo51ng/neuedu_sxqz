package com.neuedu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*@WebListener*/
public class Test1listener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("servletcontext对象创建");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servletcontext对象销毁");
	}
	
}
