package com.dragon.pojo;

import java.util.Date;

public class Real {
     private int id;//主键
     private String cardid;//引用user表的主键
     private String projectname;//项目名称
     private String address;//地址
     private String housetype;//房屋类型
     private int area;//房屋面积
     private Date buildtime;//建造时间
     private Users user;     
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Date getBuildtime() {
		return buildtime;
	}
	public void setBuildtime(Date buildtime) {
		this.buildtime = buildtime;
	}
	public Real(int id, String cardid, String projectname, String address, String housetype, int area,
			Date buildtime) {
		super();
		this.id = id;
		this.cardid = cardid;
		this.projectname = projectname;
		this.address = address;
		this.housetype = housetype;
		this.area = area;
		this.buildtime = buildtime;
	}
	public Real() {
		super();
	}     
}
