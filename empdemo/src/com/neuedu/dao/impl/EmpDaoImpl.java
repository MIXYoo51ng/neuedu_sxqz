package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.EmpDao;
import com.neuedu.entity.Emp;
import com.neuedu.util.DataSourceUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public List<Emp> selectEmpList() {
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		List<Emp> emplist = new ArrayList<Emp>();
		try {
			conn = DataSourceUtil.getConnection();
			String sql = "select * from e_emp";
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				emplist.add(new Emp(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"),
						rs.getString("job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				sta.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return emplist;
	}

	@Override
	public Emp selectEmpById(int id) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			conn = DataSourceUtil.getConnection();
			String sql = "select * from e_emp where id = ?";
			psta = conn.prepareStatement(sql);
			psta.setInt(1, id);
			rs = psta.executeQuery();
			while(rs.next()){
				emp = new Emp(rs.getInt("id"), rs.getString("name"), rs.getInt("salary"),
						rs.getString("job"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				psta.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return emp;
	}
	
	
	
}
