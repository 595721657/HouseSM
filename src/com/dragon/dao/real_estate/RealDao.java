package com.dragon.dao.real_estate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dragon.pojo.Real;

public interface RealDao {
	//ͨ���û��������֤��Ϣ��ѯ��ҳ�ķ���������ɸѡ
    List<Real> getAll(@Param("form") int currPage,@Param("pageSize") int pageSize,@Param("id") String cardid,@Param("name") String name);
    //��ѯ���ݿ�����
    int getCount(@Param("id") String cardid,@Param("name") String name);
}
