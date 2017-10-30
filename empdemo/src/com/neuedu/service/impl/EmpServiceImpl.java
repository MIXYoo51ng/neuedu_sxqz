package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.EmpDao;
import com.neuedu.dao.impl.EmpDaoImpl;
import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;

public class EmpServiceImpl implements EmpService{

	@Override
	public List<Emp> selectEmpList() {
		EmpDao empdao = new EmpDaoImpl();
		return empdao.selectEmpList();
	}

	@Override
	public Emp selectEmpById(int id) {
		EmpDao empdao = new EmpDaoImpl();
		return empdao.selectEmpById(id);
	}

}
