package com.neuedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;

public class Test {
	public static void main(String[] args) {
		//1.�õ�mybatis��sqlsession����
		//Test.class.getClassLoader().getResourceAsStream("myBatis.xml")
		//����ĸ��ݾ�������
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
				Test.class.getClassLoader().getResourceAsStream("myBatis.xml"));
		//2.ͨ�������������ݿ�Ự����
		SqlSession session = factory.openSession();
		//3.ʹ��sessionִ��sql
//		Emp emp = session.selectOne("com.neuedu.emp.selectAll");
//		List<Emp> emplist = session.selectList("com.neuedu.emp.selectAll");
//		System.out.println(emplist);
//		EmpDao empdao = new EmpDaoImpl();
//		List<Emp> emplist = empdao.selectAll();
//		Emp emp = empdao.selectEmpByid(1001);
//		System.out.println(emp);
		//���ö�̬����ķ�ʽ����ʵ����
		EmpDao empdao = session.getMapper(EmpDao.class);
		List<Emp> emplist = empdao.selectAll();
		System.out.println(emplist);
//		Emp emp = empdao.selectEmpByid(1001);
//		System.out.println(emp);
	}
}
