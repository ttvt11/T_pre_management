package com.kimschool.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "calendar")
@NamedQueries({
	@NamedQuery(
			name = "Calendar.jointest",
			query = "select c from Calendar c LEFT JOIN c.wbs_2020 cj where c.yyyy = :yyyy and c.mm = :mm"
			),
})

@Setter
@Getter
@ToString
public class Calendar {

   @Id
   private String yyyymmdd;
   private String yyyy;
   private String mm;
   private String dd;
   private String day;
   private String holiday;

   @OneToOne
   @JoinColumn(name="yyyymmdd")
   private Wbs_2020 wbs_2020 = new Wbs_2020();


}