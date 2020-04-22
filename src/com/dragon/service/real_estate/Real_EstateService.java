package com.dragon.service.real_estate;

import java.util.List;


import com.dragon.pojo.Real;

public interface Real_EstateService {
	//通过用户名和身份证信息查询分页的方法多条件筛选
    List<Real> getAll(int currPage,int pageSize,String cardid,String name);
    //查询数据库条数
    int getCount(String cardid,String name);
}
