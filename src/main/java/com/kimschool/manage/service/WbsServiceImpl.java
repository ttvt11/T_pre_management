package com.kimschool.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.kimschool.manage.dao.WbsDao;
import com.kimschool.manage.entity.Calendar;
import com.kimschool.manage.entity.User_Info;
import com.kimschool.manage.entity.Wbs;
import com.kimschool.manage.entity.WbsInfoVo;
import com.kimschool.manage.entity.Wbs_2020;
import com.kimschool.manage.entity.WorkPlaceInfo;
import com.kimschool.manage.service.util.DateUtil;

@Service
public class WbsServiceImpl implements WbsService {
	
	private static final Logger logger = LoggerFactory.getLogger(WbsServiceImpl.class);

	@Autowired
	private WbsDao wbsDao;
	
	@Autowired
	private DateUtil dateUitl;

	@Override
	public ModelAndView wbsLogincheck(String u_no, String u_password) {
		

		
		List<User_Info> result = wbsDao.wbsLogincheck(u_no,u_password);
		
		int count = result.size();
		
		ModelAndView mv = new ModelAndView();

		
		if(count == 1) {
			DateUtil dateUtil = new DateUtil();
			String[] today =dateUtil.getToday();
			
			mv.addObject("u_no", u_no);
			mv.addObject("date", today[0]+today[1]); 
			mv.setViewName("redirect:getwbsinfo");
		} else {
			mv.setViewName("home");
		}
		
		return mv;
	}

	@Override
	public ModelAndView getwbsinfo(String u_no) {
		
		ModelAndView mv = new ModelAndView("wbs");
		
		List<User_Info> user_Info = new ArrayList<User_Info>();
		List<Wbs_2020> wbs_2020 = new ArrayList<Wbs_2020>();
		List<WorkPlaceInfo> workplaceinfo = new ArrayList<WorkPlaceInfo>();
		
		user_Info = wbsDao.getuserinfo(u_no);
		wbs_2020 = wbsDao.getwbs2020(u_no);
		workplaceinfo = wbsDao.getworkplaceinfo(u_no);
		
		WbsInfoVo vo = new WbsInfoVo();
		vo.setU_name(user_Info.get(0).getName());
		vo.setU_no(user_Info.get(0).getU_no());
		vo.setMin_time(String.valueOf(workplaceinfo.get(0).getMin_time()));
		vo.setMax_time(String.valueOf(workplaceinfo.get(0).getMax_time()));
		
		List<Wbs> wbslist = new ArrayList<Wbs>();
		
		DateUtil dateUtil = new DateUtil();
		for(Wbs_2020 wbs : wbs_2020) {
			Wbs wbsvo = new Wbs();
			
			wbsvo.setDate(wbs.getDate());
			wbsvo.setStart_h(wbs.getStart_time().substring(0,2));
			wbsvo.setStart_m(wbs.getStart_time().substring(2,4));
			wbsvo.setEnd_h(wbs.getEnd_time().substring(0,2));
			wbsvo.setEnd_m(wbs.getEnd_time().substring(2,4));
			wbsvo.setTotal_h(dateUtil.timeConv(wbs.getStart_time(),wbs.getEnd_time(),wbs.getRest_time()));
			
/*			String startTime = wbs.getStart_time();
			Double startTimeInt = Double.valueOf(startTime);
			String endTime = wbs.getEnd_time();
			Double endTimeInt = Double.valueOf(endTime);
			String restTime = wbs.getRest_time();
			Double restTimeInt = Double.valueOf(restTime);
			Double totalH = (((endTimeInt - startTimeInt - restTimeInt) / 100));
			DecimalFormat formatter = new DecimalFormat("#,##0.00");
			String total_hStr = formatter.format(totalH);
			wbsvo.setTotal_h(total_hStr);*/
			
			wbsvo.setVacation_type(dateUtil.vacationCatConv(wbs.getVacation_type()));
	        /* if(wbs.getVacation_type().equals("0")) {
	        	 wbsvo.setVacation_type("");
	          } else if (wbs.getVacation_type().equals("1")){
	        	  wbsvo.setVacation_type("오전휴가");
	          } else if (wbs.getVacation_type().equals("2")){
	        	  wbsvo.setVacation_type("오후휴가");
	          } else if (wbs.getVacation_type().equals("3")){
	        	  wbsvo.setVacation_type("휴일");
	          } else if (wbs.getVacation_type().equals("4")){
	        	  wbsvo.setVacation_type("조퇴");
	          }*/
			wbsvo.setMemo(wbs.getMemo());
			wbslist.add(wbsvo);
		}
		
		vo.setWbslist(wbslist);
		
		mv.addObject("wbsinfo", vo);
		
		return mv;
	}
	
	//조인
	@Override
	public ModelAndView getJoin(String u_no,  String date, String mod) {
		
		ModelAndView mv = new ModelAndView("wbs");
		DateUtil dateUtil = new DateUtil();
		
		List<Calendar> calendarList = new ArrayList<Calendar>();
		List<User_Info> user_Info = new ArrayList<User_Info>();
		List<WorkPlaceInfo> workplaceinfo = new ArrayList<WorkPlaceInfo>();
		//List<Wbs_2020> wbs_2020 = new ArrayList<Wbs_2020>();
		
		user_Info = wbsDao.getuserinfo(u_no);
		workplaceinfo = wbsDao.getworkplaceinfo(u_no);
		//calendarList = wbsDao.getJoin(date);//

		WbsInfoVo vo = new WbsInfoVo();
		String currDate = date;
		
		if(mod != null & "pre".equals(mod)) {
			int chgDate = Integer.parseInt(date)-1;
			currDate = String.valueOf(chgDate);
			calendarList = wbsDao.getJoin(currDate);// 조인케리
		} else if (mod != null & "next".equals(mod)) {
			int chgDate = Integer.parseInt(date)+1;
			currDate = String.valueOf(chgDate);
			calendarList = wbsDao.getJoin(currDate);// 조인케리
		} else {
			calendarList = wbsDao.getJoin(date);// 
		}
		vo.setU_name(user_Info.get(0).getName());
		vo.setU_no(user_Info.get(0).getU_no());
		vo.setMin_time(String.valueOf(workplaceinfo.get(0).getMin_time()));
		vo.setMax_time(String.valueOf(workplaceinfo.get(0).getMax_time()));
		
		List<Wbs> wbslist = new ArrayList<Wbs>();
		
		for(Calendar calendar : calendarList) {
			Wbs wbsvo = new Wbs();
			
			//롬복 빌더사용시.
/*			Wbs wbsvo = Wbs.builder().
					dayColor(dateUtil.dayColorConv(calendar.getDay())).
					date(calendar.getYyyymmdd()).
					day(dateUtil.dayConv(calendar.getDay())).build();*/
			
			
			wbsvo.setDayColor(dateUtil.dayColorConv(calendar.getDay()));
			wbsvo.setDate(calendar.getYyyymmdd());
			wbsvo.setDay(dateUtil.dayConv(calendar.getDay()));

			Wbs_2020 wbs_2020 = calendar.getWbs_2020();
			
	         if(wbs_2020 != null) {
	             wbsvo.setStart_h(wbs_2020.getStart_time().substring(0, 2));
	             wbsvo.setStart_m(wbs_2020.getStart_time().substring(2, 4));
	             wbsvo.setEnd_h(wbs_2020.getEnd_time().substring(0, 2));
	             wbsvo.setEnd_m(wbs_2020.getEnd_time().substring(2, 4));
	             wbsvo.setTotal_h(dateUtil.timeConv(wbs_2020.getStart_time(), wbs_2020.getEnd_time(), wbs_2020.getRest_time()));
	             wbsvo.setVacation_type(wbs_2020.getVacation_type()); // 과제
	             wbsvo.setMemo(wbs_2020.getMemo());
	             wbsvo.setProcess("update");
	          } else {
	             wbsvo.setStart_h("00");
	             wbsvo.setStart_m("00");
	             wbsvo.setEnd_h("00");
	             wbsvo.setEnd_m("00");
	             wbsvo.setTotal_h("0.00");
	             wbsvo.setVacation_type("0"); // 과제
	             wbsvo.setMemo("");
	             wbsvo.setProcess("insert");
	          }
			wbslist.add(wbsvo);
		}
		
		vo.setWbslist(wbslist);
		
		mv.addObject("wbsinfo", vo);
		
		List<String> hours = new ArrayList<String>();
		for(int i =0; i < 24; i++) {
			if(i < 10) {
				hours.add("0" + Integer.toString(i));
			} else { 
				hours.add(Integer.toString(i));
			}
		}

		List<String> minutes = new ArrayList<String>();
		minutes.add("00");
		minutes.add("15");
		minutes.add("30");
		minutes.add("45");
		
		Map<String ,String> vacationCode = new HashMap<String, String>(); 
		vacationCode.put("0", "-------");
		vacationCode.put("1", "午前休");
		vacationCode.put("2", "午後休");
		vacationCode.put("3", "全休");
		vacationCode.put("4", "早退");
		
		mv.addObject("hours",hours);
		mv.addObject("minutes",minutes);
		mv.addObject("vacationCode",vacationCode);
		mv.addObject("date",currDate);
		
		return mv;
		
	}

	@Override
	public ModelAndView regWbs2020(String u_no, List<Wbs> wbsList) {

		List<Wbs_2020> wbs2020List = convWbsInfo(u_no, wbsList);
		int result = wbsDao.regWbs2020(wbs2020List);
		logger.info(result + "건의 데이터가 변경 또는 삽입되었습니다.");
		
		String[] today = dateUitl.getToday();
		
		ModelAndView mv = new ModelAndView("redirect:/getwbsinfo");
		
		mv.addObject("u_no", u_no);
		mv.addObject("date", today[0]+today[1]); 
		
		return mv;
	}

	public List<Wbs_2020> convWbsInfo(String u_no, List<Wbs> wbsList) {

		List<Wbs_2020> wbs2020List = new ArrayList<Wbs_2020>();
		Wbs_2020 wbs2020 = new Wbs_2020();

		for(Wbs wbs : wbsList) {
			wbs2020.setDate(wbs.getDate());
			wbs2020.setStart_time(wbs.getStart_h() + wbs.getStart_m());
			wbs2020.setEnd_time(wbs.getEnd_h() + wbs.getEnd_m());
			wbs2020.setRest_time("0100");
			wbs2020.setU_no("010010001");
			wbs2020.setVacation_type(wbs.getVacation_type());
			wbs2020.setMemo(wbs.getMemo());
			wbs2020List.add(wbs2020);
		}

		return wbs2020List;
	}


	}
