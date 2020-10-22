package com.kimschool.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_info")
@NamedQueries({

	@NamedQuery(
			name = "User_Info.findByu_no",
			query = "select u from User_Info u where u.u_no = :u_no "),
	@NamedQuery(
	        name = "User_Info.findByUserInfo",
	        query = "select u from User_Info u where u.u_no = :u_no and u.u_password = :u_password")
})

@Setter
@Getter
@ToString
public class User_Info {

	@Id //pk에 지정해주는 어노테이션
	   private int no;
	   @Column(insertable = false)
	   private String u_no;
	   @Column(insertable = false)
	   private String u_password;
	   @Column(insertable = false)
	   private String name;
	   //inset시 값이 들어가는걸 방지한다(null)
	   @Column(insertable = false)
	   private String gender;
	   @Column(insertable = false)
	   private String email;
	   @Column(insertable = false)
	   private String address;
	   @Column(insertable = false)
	   private String mobile_number;
	   @Column(insertable = false)
	   private String hire_date;
	   @Column(insertable = false)
	   private String reg_date;
	   @Column(insertable = false)
	   private String upd_date;
	   @Column(insertable = false)
	   private String upd_user;


}