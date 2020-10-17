package com.kimschool.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.service.RegUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RegUserController {
	
	@Autowired
	RegUserService regUserService;

	private static final Logger logger = LoggerFactory.getLogger(RegUserController.class);

	@RequestMapping("/movereguser")
	public String muvereguser() {
		
		logger.info("회원가입 화면 이동처리");
		
		return "reguser";
	}
	
	@RequestMapping("/reguser")
	public ModelAndView reguser(String id, String password, String email1, String email2) {
		logger.info("회원가입 정보입력 처리");
		//회원가입 성공시 -> home.jsp ->msg회원가입 완료
		//회원가입 실패시 redirect-> reguser.jsp ->msg내용을 확인해주세요?
		ModelAndView mv = new ModelAndView();
		int result = regUserService.insertUserInfo(id, password, email1, email2);
		
		if(result == 0 ) {
			mv.setViewName("home");
			mv.addObject("회원가입이 완료되었습니다.");
		} else {
			mv.setViewName("redirect:/movereguser");
		}
		
		
		return mv;
	}
}