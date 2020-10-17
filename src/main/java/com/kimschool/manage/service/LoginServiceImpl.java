package com.kimschool.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimschool.manage.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao logindao;

	@Override
	public int checkLogin(String id, String password) {
		int count = logindao.findUser(id, password);
		return count;
	}

}