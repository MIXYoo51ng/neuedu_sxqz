package com.neuedu.filter_gg;
/**
 * java8之后接口中可以写实现方法,但是有规则
 * 1.能写静态方法
 * 2.默认实现方法default
 * @author neuedu
 *
 */
public interface Testinterface {
	public static void add(){
		System.out.println("这是接口中的静态方法");
	}
	
	public default void adddefault(){
		System.out.println(1);
	}
	
	
	
}
