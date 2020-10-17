package com.kimschool.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "wbs_2020")
@NamedQuery(
      name = "Wbs_2020.findByu_no",
      query = "select w from Wbs_2020 w where w.u_no = :u_no"
      )

@Setter
@Getter
@ToString
public class Wbs_2020 {

   @Id
   private String date;
   private String u_no;
   private String start_time;
   private String end_time;
   private String rest_time;
   private String vacation_type;
   private String memo;
   private String reg_date;
   private String upd_date;
   
   
}