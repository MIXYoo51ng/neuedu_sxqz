package com.neuedu.entity;

import java.util.List;

public class Dept {
	
	private Integer deptno;
	private String dname;
	private String location;
	
	private List<Emp> emplist;
	
	public Dept() {
		super();
	}
	public Dept(Integer deptno, String dname, String location) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}
	
	public Dept(Integer deptno, String dname, String location, List<Emp> emplist) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
		this.emplist = emplist;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public List<Emp> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", location=" + location + ", emplist=" + emplist + "]";
	}
	
}
