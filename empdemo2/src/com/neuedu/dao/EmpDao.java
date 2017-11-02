package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpDao {
	
	public List<Emp> selectAllEmp();
	
	public int deleteEmpById(int id);
	
}
