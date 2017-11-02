package com.neuedu.service;

import com.neuedu.entity.User;

public interface UserService {
	
	public User selectUserByUsername(String username);
	
}
