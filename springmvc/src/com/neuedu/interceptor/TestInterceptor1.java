package com.neuedu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor1 implements HandlerInterceptor{

	/**
	 * ����ͼ�������֮��ִ��,ʵ����ûɶ��,һ��Ҳ����������������
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("������1��afterCompletion����");
	}

	/**
	 * ��controllerִ�����֮��,������modelandview������ͼ����������modelandview֮ǰִ���������
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handle, ModelAndView model)
			throws Exception {
		System.out.println("������1��postHandle����");
	}
	/**
	 * ��controllerִ��֮ǰִ���������,�������ֵΪtrue,��springmvc��������ִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handle) throws Exception {
		System.out.println("������1��preHandle����");
		return true;
	}
}
