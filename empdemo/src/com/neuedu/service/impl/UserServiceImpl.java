package com.neuedu.service.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User selectUserByUsername(String username) {
		UserDao userdao = new UserDaoImpl();
		return userdao.selectUserByUsername(username);
	}

}
