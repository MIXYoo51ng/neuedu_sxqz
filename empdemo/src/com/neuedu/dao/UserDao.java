package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDao {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User selectUserByUsername(String username);
	
	/**
	 * 插入user数据
	 * @param user
	 */
	public int insertUser(User user);
	
}
