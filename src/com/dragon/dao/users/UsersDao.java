package com.dragon.dao.users;

import org.apache.ibatis.annotations.Param;

import com.dragon.pojo.Users;

public interface UsersDao {
       //��¼��֤�ķ���
	   int isValidation(@Param("id") String cardid,@Param("psw") String password);
	   //ע��ķ���
	   int addUsers(Users user);
	   //ͨ�����֤��ѯ��Ϣ
	   Users getByCarId(@Param("id") String cardid);
}
