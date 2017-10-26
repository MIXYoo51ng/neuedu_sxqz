package com.neuedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AttributeListenerTest implements ServletContextAttributeListener{
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("有参数进入servletcontext");
		System.out.println("参数key:"+event.getName());
		System.out.println("参数value:"+event.getValue());
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("有参数删除servletcontext");
		System.out.println("参数key:"+event.getName());
		System.out.println("参数value:"+event.getValue());
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("有参数替换servletcontext");
		System.out.println("参数key:"+event.getName());
		System.out.println("参数value:"+event.getValue());
	}
	
}
