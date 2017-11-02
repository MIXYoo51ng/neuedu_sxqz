package com.neuedu.entity;

public class Emp {
	
	private Integer empno;
	private String ename;
	private Integer salary;
	private String job;
	private Integer deptno;
	
	public Emp() {
		super();
	}
	
	public Emp(Integer empno, String ename, Integer salary, String job, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.job = job;
		this.deptno = deptno;
	}
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", job=" + job + ", deptno=" + deptno
				+ "]";
	}
	
}
