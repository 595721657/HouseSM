package com.dragon.service.users;

import com.dragon.pojo.Users;

public interface UsersService {
	   //��¼��֤�ķ���
	   boolean isValidation(String cardid,String password);
	   //ע��ķ���
	   boolean addUsers(Users user);
	   //ͨ�����֤��ѯ��Ϣ
	   Users getByCarId(String cardid);
}
