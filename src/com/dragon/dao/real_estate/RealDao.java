package com.dragon.dao.real_estate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dragon.pojo.Real;

public interface RealDao {
	//通过用户名和身份证信息查询分页的方法多条件筛选
    List<Real> getAll(@Param("form") int currPage,@Param("pageSize") int pageSize,@Param("id") String cardid,@Param("name") String name);
    //查询数据库条数
    int getCount(@Param("id") String cardid,@Param("name") String name);
}
