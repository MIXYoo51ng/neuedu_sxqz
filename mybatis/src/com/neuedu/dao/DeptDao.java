package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Dept;

public interface DeptDao {

	
	/**
	 * ��ѯ���в�����Ϣ��������Ա����Ϣ
	 * @return
	 */
	public List<Dept> selectDeptEmp();
	
}
