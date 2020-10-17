package com.kimschool.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	DataSource ds;
	
	@RequestMapping("login")
	public ModelAndView login() throws ClassNotFoundException, SQLException {
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		
		//SQL접속
		conn = ds.getConnection();
		
		
		//SQL생성
		String sql = "select now()";
		ps = conn.prepareStatement(sql);
		// SQL실행
		rs = ps.executeQuery();
		//rs로부터 취득값 출력
		while(rs.next()) {
			//rs로부터 시간값 취득
			String time = rs.getString("now()");
			//취득값 취득
			System.out.println(time);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		return mv;
	}
}
