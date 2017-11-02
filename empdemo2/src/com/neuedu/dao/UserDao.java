package com.neuedu.dao;

import com.neuedu.entity.User;

public interface UserDao {
	
	public User selectUserByUsername(String username);
	
}
