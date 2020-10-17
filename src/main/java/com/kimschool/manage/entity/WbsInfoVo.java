package com.kimschool.manage.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class WbsInfoVo {

	private String u_name;
	private String u_no;
	private String min_time;
	private String max_time;
	
	List<Wbs> wbslist;
	
	

	
}


