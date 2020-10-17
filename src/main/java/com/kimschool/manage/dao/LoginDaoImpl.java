package com.kimschool.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimschool.manage.entity.User_Info;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	Connection conn;


	@Override
	public int findUser(String id, String password) {
		EntityManager em = conn.getConnection();
		List<User_Info> result = em.createNamedQuery("User_Info.findBypassword", User_Info.class).
				setParameter("password", password).
				setParameter("id", id).
				getResultList();
		
		int size = result.size();
		
		return size;
	}

}
