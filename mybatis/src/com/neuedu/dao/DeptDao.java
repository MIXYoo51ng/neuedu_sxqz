package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Dept;

public interface DeptDao {

	
	/**
	 * 查询所有部门信息包括所有员工信息
	 * @return
	 */
	public List<Dept> selectDeptEmp();
	
}
