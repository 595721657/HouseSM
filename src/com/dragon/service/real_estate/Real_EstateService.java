package com.dragon.service.real_estate;

import java.util.List;


import com.dragon.pojo.Real;

public interface Real_EstateService {
	//ͨ���û��������֤��Ϣ��ѯ��ҳ�ķ���������ɸѡ
    List<Real> getAll(int currPage,int pageSize,String cardid,String name);
    //��ѯ���ݿ�����
    int getCount(String cardid,String name);
}
