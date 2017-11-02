package com.neuedu.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.util.SqlSessionUtil;

public class CurdTest {
	public static void main(String[] args) {
		//��session
		SqlSession session = SqlSessionUtil.FACTORY.openSession();
		//����empdao�ӿڵ�ʵ����
		EmpDao empdao = session.getMapper(EmpDao.class);
		//1.��ѯȫ��
//		List<Emp> emplist = empdao.selectAll();
//		System.out.println(emplist);
		//2.����empno��ѯ
//		Emp emp = empdao.selectEmpByEmpno(1001);
//		System.out.println(emp);
		//3.���һ������
//		int i = empdao.addEmp(new Emp(1007,"��������",100,"����ְҵ",10));
//		System.out.println(i);
//		session.commit();
		//4.ɾ������
//		int i = empdao.deleteEmpByEmpno(1007);
//		System.out.println(i);
//		session.commit();
		//5.�޸�����
		int i = empdao.updateEmp(new Emp(1007,"��������",100,"����ְҵ",10));
		System.out.println(i);
		session.commit();
	}
}
