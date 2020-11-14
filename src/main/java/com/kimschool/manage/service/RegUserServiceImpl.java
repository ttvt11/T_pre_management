package com.kimschool.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.manage.dao.RegUserDao;
import com.kimschool.manage.entity.User_Info;

@Service
public class RegUserServiceImpl implements RegUserService {

	@Autowired
	RegUserDao regUserDao;


	@Override
	public int insertUserInfo(User_Info userInfo) {

		/*	User_Info userInfo = new User_Info();

			userInfo.setU_no(u_no);
			userInfo.setU_password(u_password);
			userInfo.setName(name);
			userInfo.setGender(gender);
			userInfo.setEmail(email);
			userInfo.setAddress(address);
			userInfo.setMobile_number(mobile_number);
			userInfo.setHire_date(hire_date);*/

		int result = regUserDao.insertUserInfo(userInfo);





		return result;
	}

}