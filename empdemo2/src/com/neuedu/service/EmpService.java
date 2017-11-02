package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Emp;

public interface EmpService {

	public List<Emp> selectAllEmp();
	
	public int deleteEmpById(int id);
}
