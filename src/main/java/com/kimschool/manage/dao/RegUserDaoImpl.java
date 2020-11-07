package com.kimschool.manage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimschool.manage.entity.User_Info;

@Repository
public class RegUserDaoImpl implements RegUserDao{

	@Autowired
	Connection conn;


	@Override
	public int insertUserInfo(User_Info userInfo) {

		EntityManager em = conn.getConnection();
		EntityTransaction ent = em.getTransaction();

		//트렌젝션 open
		ent.begin();
		User_Info userInfo1 = new User_Info();

		userInfo1.getU_no();

		ent.(userInfo1);

		//트렌젝션 close직전 코밋
		ent.commit();

		return 0;
	}

}