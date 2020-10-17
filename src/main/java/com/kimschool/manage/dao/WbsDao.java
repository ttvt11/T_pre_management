package com.kimschool.manage.dao;

import java.util.List;

import com.kimschool.manage.entity.Calendar;
import com.kimschool.manage.entity.User_Info;
import com.kimschool.manage.entity.Wbs_2020;
import com.kimschool.manage.entity.WorkPlaceInfo;

public interface WbsDao {

	public List<User_Info> wbsLogincheck(String u_no, String u_password);

	public List<Wbs_2020> getwbs2020(String u_no);
	public List<User_Info> getuserinfo(String u_no);
	public List<WorkPlaceInfo> getworkplaceinfo(String u_no);

	public List<Calendar> getJoin(String date);

	public int regWbs2020(List<Wbs_2020> wbsList);

}