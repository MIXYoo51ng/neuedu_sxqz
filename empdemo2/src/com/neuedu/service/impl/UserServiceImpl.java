package com.neuedu.service.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.util.DaoImplUtil;

public class UserServiceImpl implements UserService{

	@Override
	public User selectUserByUsername(String username) {
		UserDao userdao = DaoImplUtil.getImpl(UserDao.class, true);
		return userdao.selectUserByUsername(username);
	}

}
