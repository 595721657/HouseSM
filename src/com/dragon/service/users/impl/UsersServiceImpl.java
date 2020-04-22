package com.dragon.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dragon.dao.users.UsersDao;
import com.dragon.pojo.Users;
import com.dragon.service.users.UsersService;
@Service("userService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	//创建一个dao层对象
	@Qualifier("usersDao")
	private UsersDao usersDao;
	@Override
	public boolean isValidation(String cardid, String password) {
		if(usersDao.isValidation(cardid, password)>0) {
			return true;
		}else {
			return false;
		}		
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean addUsers(Users user) {
		if(usersDao.addUsers(user)>0) {
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public Users getByCarId(String cardid) {
		return usersDao.getByCarId(cardid);
	}

}
