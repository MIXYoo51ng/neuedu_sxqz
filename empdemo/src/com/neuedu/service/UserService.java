package com.neuedu.service;

import com.neuedu.entity.User;

public interface UserService {

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public User selectUserByUsername(String username);
	
}
