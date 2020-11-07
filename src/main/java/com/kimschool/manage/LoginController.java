package com.kimschool.manage;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(RegUserController.class);

	@Autowired
	DataSource ds;

	@RequestMapping("/moveLogin")
	public String init() {

		logger.info("로그인 화면 이동처리");

		return "login";
	}

	/*@RequestMapping("login")
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
		}*/
}
