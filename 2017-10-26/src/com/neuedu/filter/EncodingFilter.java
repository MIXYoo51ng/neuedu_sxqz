package com.neuedu.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	private String Encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Encoding = filterConfig.getInitParameter("Encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (Encoding == null) {
			request.setCharacterEncoding("UTF-8");
		}else{
			request.setCharacterEncoding(Encoding);
		}
		chain.doFilter(request, response);
	}

}
