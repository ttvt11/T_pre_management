package com.kimschool.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.manage.dao.RegUserDao;

@Service
public class RegUserServiceImpl implements RegUserService {

	@Autowired
	RegUserDao regUserDao;
	
	@Override
	public int insertUserInfo(String id, String password, String email1, String email2) {
		
/*		User_Info userInfo = new User_Info();
		userInfo.setId(id);
		userInfo.setPassword(password);
		String email = email1 + "@" + email2;
		userInfo.setEmail(email);
		
		int result = regUserDao.insertUserInfo(userInfo);
		*/
		return 0;
	}

}