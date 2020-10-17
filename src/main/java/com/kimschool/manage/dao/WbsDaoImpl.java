package com.kimschool.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kimschool.manage.entity.Calendar;
import com.kimschool.manage.entity.User_Info;
import com.kimschool.manage.entity.Wbs_2020;
import com.kimschool.manage.entity.WorkPlaceInfo;

@Repository
public class WbsDaoImpl implements WbsDao {
	
	@Autowired
	Connection conn;
	
	@Override
	public List<User_Info> wbsLogincheck(String u_no, String u_password) {
		EntityManager em = conn.getConnection();
		List<User_Info> result = em.createNamedQuery("User_Info.findByUserInfo", User_Info.class).
				setParameter("u_no", u_no).
				setParameter("u_password", u_password).
				getResultList();
		return result;
	}
	
	

	@Override
	public List<Wbs_2020> getwbs2020(String u_no) {
		EntityManager em = conn.getConnection();
		List<Wbs_2020> result = em.createNamedQuery("Wbs_2020.findByu_no", Wbs_2020.class).
				setParameter("u_no", u_no).
				getResultList();
		return result;
	}

	@Override
	public List<User_Info> getuserinfo(String u_no) {
		EntityManager em = conn.getConnection();
		List<User_Info> result = em.createNamedQuery("User_Info.findByu_no", User_Info.class).
				setParameter("u_no", u_no).
				getResultList();
		return result;
	}


	@Override
	public List<WorkPlaceInfo> getworkplaceinfo(String u_no) {
		EntityManager em = conn.getConnection();
		List<WorkPlaceInfo> result = em.createNamedQuery("WorkPlaceInfo.findByu_no", WorkPlaceInfo.class).
				setParameter("u_no", u_no).
				getResultList();
		return result;
	}



	@Override
	public List<Calendar> getJoin(String date) {
		EntityManager em = conn.getConnection();
		List<Calendar> result = em.createNamedQuery("Calendar.jointest", Calendar.class).
				setParameter("yyyy", date.substring(0,4)).
				setParameter("mm", date.substring(4,6)).
				getResultList();
		return result;
	}



	@Override
	public int regWbs2020(List<Wbs_2020> wbsList) {
		EntityManager em = conn.getConnection();

		//em.getTransaction().begin();
		//try {

			for (Wbs_2020 wbs : wbsList) {
				em.merge(wbs);
				//em.persist(wbs);
			}

			//em.getTransaction().commit();//재기동필요

			return wbsList.size();
		/*} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return 0;
		}*/
	}

}
