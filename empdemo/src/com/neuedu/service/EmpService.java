package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpService {
	
	/**
	 * 查询全部emp
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
