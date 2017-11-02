package com.neuedu.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoImplUtil {
	
	private static final SqlSessionFactory FACTORY = new SqlSessionFactoryBuilder()
			.build(DaoImplUtil.class.getClassLoader().getResourceAsStream("mybatisConfig.xml"));
	
	public static <T> T getImpl(Class c,boolean isAutoCommit){
		SqlSession session = FACTORY.openSession(isAutoCommit);
		return (T) session.getMapper(c);
	}
	
}
