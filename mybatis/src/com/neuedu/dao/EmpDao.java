package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.entity.Emp;

public interface EmpDao {
	
	/**
	 * ��ѯȫ��emp
	 * @return
	 */
	public List<Emp> selectAll();
	
	/**
	 * ����empno��ѯemp
	 * @param empno
	 * @return
	 */
	public Emp selectEmpByEmpno(int empno);
	
	/**
	 * ����emp���һ������
	 * @param emp
	 * @return
	 */
	public int addEmp(Emp emp);
	
	/**
	 * ����Ա����Ž���ɾ��
	 * @param empno
	 * @return
	 */
	public int deleteEmpByEmpno(int empno);
	
	/**
	 * �޸�Ա����Ϣ
	 * @param emp
	 * @return
	 */
	public int updateEmp(Emp emp);
	
	/**
	 * ����Ա��������Ա��
	 * @param ename
	 * @return
	 */
	public Emp selectEmpByEname(@Param("ename")String ename);
	
	
	//public Emp selectEmpByEnameEno(@Param("empno")int empno,@Param("ename")String ename);
	public Emp selectEmpByEnameEno(Map<String, Object> map);
	
	/**
	 * ��ѯ����Ա����Ϣ����������Ϣ
	 * @return
	 */
	public List<Emp> selectEmpDept();
	
}
