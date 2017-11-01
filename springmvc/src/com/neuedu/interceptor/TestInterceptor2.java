package com.neuedu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor2 implements HandlerInterceptor{

	/**
	 * 在视图解析完成之后执行,实际上没啥用,一般也就用来做个清理缓存
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截器2的afterCompletion方法");
	}

	/**
	 * 在controller执行完成之后,返回了modelandview，在视图解析器解析modelandview之前执行这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handle, ModelAndView model)
			throws Exception {
		System.out.println("拦截器的2postHandle方法");
	}

	/**
	 * 在controller执行之前执行这个方法,如果返回值为true,则springmvc继续向下执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
		System.out.println("拦截器的2preHandle方法");
		return true;
	}

}
