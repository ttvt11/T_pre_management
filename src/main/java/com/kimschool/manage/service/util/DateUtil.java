package com.kimschool.manage.service.util;

import java.text.DecimalFormat;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

   // 근무형태 변환 기능
   // 0 : 미표시
   // 1 : 오전휴가
   // 2 : 오후휴가
   // 3 : 종일휴가
   // 4 : 조퇴
   public String vacationCatConv(String vacationCode) {
      if("0".equals(vacationCode)) {
         return "";
      } else if("1".equals(vacationCode)) {
         return "오전휴가";
      } else if("2".equals(vacationCode)) {
         return "오후휴가";
      } else if("3".equals(vacationCode)) {
         return "종일휴가";
      } else if("4".equals(vacationCode)) {
         return "조퇴";
      } else {
         return "";
      }
   }

   // 요일 변환 기능
   public String dayConv(String day) {
      if("0".equals(day)) {
         return "(月)";
      } else if("1".equals(day)) {
         return "(火)";
      } else if("2".equals(day)) {
         return "(水)";
      } else if("3".equals(day)) {
         return "(木)";
      } else if("4".equals(day)) {
         return "(金)";
      } else if("5".equals(day)) {
         return "(土)";
      } else if("6".equals(day)) {
         return "(日)";
      } else {
         return "";
      }
   }

   public String dayColorConv(String day) {

      if("5".equals(day)) {
         return "blue";
      } else if("6".equals(day)) {
         return "red";
      } else {
         return "black";
      }
   }

   // 시간 더하기 기능
   // 표시 형식 : ##.##(소수점 2자리)
   public String timeConv(String startTime, String endTime, String restTime) {

      float start_h = Float.parseFloat(startTime.substring(0,2));
      float start_m = Float.parseFloat(startTime.substring(2,4));
      float end_h = Float.parseFloat(endTime.substring(0,2));
      float end_m = Float.parseFloat(endTime.substring(2,4));
      float rest_h = Float.parseFloat(restTime.substring(0,2));
      float rest_m = Float.parseFloat(restTime.substring(2,4));

      // 총시간 = 종료시간 - 시작시간
      float totaltime = end_h + (end_m / 60) - (start_h + (start_m / 60) + rest_h + (rest_m / 60));

      // 초기화와 동시에 자리수 설정
      DecimalFormat df = new DecimalFormat("0.00");

      String converted_time = df.format(totaltime);

      return converted_time;
   }

   public String[] getToday() {

      LocalDate today = LocalDate.now(); // 현재 시간을 받아온다.
      String yyyy = today.toString().substring(0, 4); // 받아온 현재 시간으로부터 yyyy만 잘라낸다.
      String mm = today.toString().substring(5, 7); // 받아온 현재 시간으로부터 mm만 잘라낸다.
      String[] date = {yyyy, mm}; // 잘라낸 yyyy, mm을 배열에 집어 넣는다.

      return date;
   }

}