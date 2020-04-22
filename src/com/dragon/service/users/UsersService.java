package com.dragon.service.users;

import com.dragon.pojo.Users;

public interface UsersService {
	   //登录验证的方法
	   boolean isValidation(String cardid,String password);
	   //注册的方法
	   boolean addUsers(Users user);
	   //通过身份证查询信息
	   Users getByCarId(String cardid);
}
