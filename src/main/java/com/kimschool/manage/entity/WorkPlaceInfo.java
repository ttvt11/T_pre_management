package com.kimschool.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "workplaceinfo")
@NamedQuery(
      name = "WorkPlaceInfo.findByu_no",
      query = "select w from WorkPlaceInfo w where w.u_no = :u_no"
      )
@Setter
@Getter
@ToString
public class WorkPlaceInfo {
   
   @Id
   @GeneratedValue
   private int no;
   @Column(insertable = false)
   private String wp_name;
   @Column(insertable = false)
   private int min_time;
   @Column(insertable = false)
   private int max_time;
   @Column(insertable = false)
   private String u_no;
   @Column(insertable = false)
   private String reg_date;
   

}