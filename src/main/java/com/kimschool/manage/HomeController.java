package com.kimschool.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.service.LoginService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	LoginService loginservice;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	//메인페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		logger.debug("초기처리");
		return mv;
	}

}
