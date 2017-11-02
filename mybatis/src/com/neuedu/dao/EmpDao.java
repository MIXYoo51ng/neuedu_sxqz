package com.neuedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	
	/**
	 * 根据员工姓名查员工
	 * @param ename
	 * @return
	 */
	public Emp selectEmpByEname(@Param("ename")String ename);
	
	
	//public Emp selectEmpByEnameEno(@Param("empno")int empno,@Param("ename")String ename);
	public Emp selectEmpByEnameEno(Map<String, Object> map);
	
	/**
	 * 查询所有员工信息包含部门信息
	 * @return
	 */
	public List<Emp> selectEmpDept();
	
}
