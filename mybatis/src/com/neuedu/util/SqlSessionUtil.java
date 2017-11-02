package com.neuedu.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.test.Test;

public class SqlSessionUtil {
	
	public static final SqlSessionFactory FACTORY = 
			new SqlSessionFactoryBuilder().build(
					Test.class.getClassLoader().getResourceAsStream("myBatis.xml"));
	
}
