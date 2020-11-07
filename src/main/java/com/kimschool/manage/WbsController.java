package com.kimschool.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.entity.WbsInfoVo;
import com.kimschool.manage.service.WbsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class WbsController {

	@Autowired
	WbsService wbsService;

	//나의근태관리페이지 이동처리
	@RequestMapping("/moveWbs")
	public ModelAndView init() {

		ModelAndView mv = new ModelAndView("wbs");

		return mv;
	}

	/*	@RequestMapping("/wbslogincheck")
		public ModelAndView wbsLogincheck(String u_no, String u_password) {

			ModelAndView mv = wbsService.wbsLogincheck(u_no, u_password);

			return mv;
		}*/

/*	@RequestMapping("/getwbsinfo")
	public ModelAndView getwbsinfo(String u_no) {

		ModelAndView mv = wbsService.getwbsinfo(u_no);

		return mv;
	}
	*/

	@RequestMapping("getwbsinfo")
	public ModelAndView getwbsinfo(String u_no, String date, String mod) {
		ModelAndView mv = wbsService.getJoin(u_no, date, mod);

		return mv;
	}

	//
	@RequestMapping("updatewbs")
	public ModelAndView getwbsinfo(String u_no, @ModelAttribute("wbsinfo") WbsInfoVo wbsInfoVo) {

		ModelAndView mv = wbsService.regWbs2020(u_no, wbsInfoVo.getWbslist());
		return mv;
	}

}
