package com.kimschool.manage.dao;

import javax.persistence.EntityManager;

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
		
		//트렌젝션 open
		em.getTransaction().begin();
		em.persist(userInfo);
		
		//트렌젝션 close직전 코밋
		em.getTransaction().commit();
		
		return 0;
	}

}