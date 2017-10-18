package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
import com.neuedu.util.DataSourceUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User selectUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DataSourceUtil.getConnection();
			String sql = "select * from e_user where username = ?";
			psta = conn.prepareStatement(sql);
			psta.setString(1, username);
			rs = psta.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
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
		return user;
	}

}
