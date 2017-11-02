package com.neuedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.util.SqlSessionUtil;

public class CurdTest {
	public static void main(String[] args) {
		//打开session
		SqlSession session = SqlSessionUtil.FACTORY.openSession();
		//生成empdao接口的实现类
		EmpDao empdao = session.getMapper(EmpDao.class);
		//1.查询全部
//		List<Emp> emplist = empdao.selectAll();
//		System.out.println(emplist);
		//2.根据empno查询
//		Emp emp = empdao.selectEmpByEmpno(1001);
//		System.out.println(emp);
		//3.添加一条数据
//		int i = empdao.addEmp(new Emp(1007,"测试数据",100,"测试职业",10));
//		System.out.println(i);
//		session.commit();
		//4.删除数据
//		int i = empdao.deleteEmpByEmpno(1007);
//		System.out.println(i);
//		session.commit();
		//5.修改数据
		int i = empdao.updateEmp(new Emp(1007,"测试数据",100,"测试职业",10));
		System.out.println(i);
		session.commit();
	}
}
