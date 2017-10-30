package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpDao {

	/**
	 * 查询出所有员工信息
	 * @return
	 */
	public List<Emp> selectEmpList();
	
	/**
	 * 根据id查询emp
	 * @param id
	 * @return
	 */
	public Emp selectEmpById(int id);
	
}
