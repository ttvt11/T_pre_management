package com.kimschool.manage.service;

//목차
public interface RegUserService {

	public int insertUserInfo(String u_no, String u_password, String name, Integer gender,String email,String address,String mobile_number,String hire_date);

}