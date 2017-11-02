package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.service.EmpService;
import com.neuedu.util.DaoImplUtil;

public class EmpServiceImpl implements EmpService{

	@Override
	public List<Emp> selectAllEmp() {
		EmpDao empdao = DaoImplUtil.getImpl(EmpDao.class, true);
		return empdao.selectAllEmp();
	}

	@Override
	public int deleteEmpById(int id) {
		EmpDao empdao = DaoImplUtil.getImpl(EmpDao.class, true);
		return empdao.deleteEmpById(id);
	}


}
