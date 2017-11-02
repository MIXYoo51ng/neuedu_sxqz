package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpDao {
	
	/**
	 * 查询全部emp
	 * @return
	 */
	public List<Emp> selectAll();
	
	/**
	 * 根据empno查询emp
	 * @param empno
	 * @return
	 */
	public Emp selectEmpByEmpno(int empno);
	
	/**
	 * 根据emp添加一条数据
	 * @param emp
	 * @return
	 */
	public int addEmp(Emp emp);
	
	/**
	 * 根据员工编号进行删除
	 * @param empno
	 * @return
	 */
	public int deleteEmpByEmpno(int empno);
	
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	public int updateEmp(Emp emp);
	
}
