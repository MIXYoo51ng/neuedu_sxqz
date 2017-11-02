package com.neuedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;

public class Test {
	public static void main(String[] args) {
		//1.拿到mybatis的sqlsession工厂
		//Test.class.getClassLoader().getResourceAsStream("myBatis.xml")
		//在类的根据经下拿流
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
				Test.class.getClassLoader().getResourceAsStream("myBatis.xml"));
		//2.通过工厂创建数据库会话对象
		SqlSession session = factory.openSession();
		//3.使用session执行sql
//		Emp emp = session.selectOne("com.neuedu.emp.selectAll");
//		List<Emp> emplist = session.selectList("com.neuedu.emp.selectAll");
//		System.out.println(emplist);
//		EmpDao empdao = new EmpDaoImpl();
//		List<Emp> emplist = empdao.selectAll();
//		Emp emp = empdao.selectEmpByid(1001);
//		System.out.println(emp);
		//采用动态代理的方式生成实现类
		EmpDao empdao = session.getMapper(EmpDao.class);
		List<Emp> emplist = empdao.selectAll();
		System.out.println(emplist);
//		Emp emp = empdao.selectEmpByid(1001);
//		System.out.println(emp);
	}
}
