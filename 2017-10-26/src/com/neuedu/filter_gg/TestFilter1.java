package com.neuedu.filter_gg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/*@WebFilter(urlPatterns="/test1.do",initParams={
		@WebInitParam(name="Encoding",value="UTF-8"),@WebInitParam(name="newParam",value="asd-8")
		}
	)*/
public class TestFilter1 implements Filter{

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("dofilter");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
		System.out.println(filterConfig.getInitParameter("Encoding"));
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}
	
}
