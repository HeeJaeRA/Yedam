package ch11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExam514 {
	
	public static void main(String[] args) {
		
		Date now = new Date();
		String strNow1 = now.toString();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2= sdf.toString();
		
		Calendar now_day = Calendar.getInstance();
		
		int year = now_day.get(Calendar.YEAR);
		int month = now_day.get(Calendar.MONTH) + 1;
		int day = now_day.get(Calendar.DAY_OF_MONTH);
		
		int week = now_day.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch (week) {
			case 1 :
				strWeek = "일";
				break;
			case 2 :
				strWeek = "월";
				break;
			case 3 :
				strWeek = "화";
				break;
			case 4 :
				strWeek = "수";
				break;
			case 5 :
				strWeek = "목";
				break;
			case 6 :
				strWeek = "금";
				break;
			case 7 :
				strWeek = "토";
				break;
		}
		
		int am_pm = now_day.get(Calendar.AM_PM);
		String strAmPm = null;
		if (am_pm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour = now_day.get(Calendar.HOUR);
		int min = now_day.get(Calendar.MINUTE);
		int sec = now_day.get(Calendar.SECOND);
		
		System.out.printf("%d년 %d월 %d일 %s요일 \n%s %d시 %d분 %d초\n", year, month, day, strWeek, strAmPm, hour, min, sec);
		
		Calendar f_day = Calendar.getInstance();
		f_day.set(2024, 1, 28);
		
		long f_days = f_day.getTimeInMillis();
		long now_days = now_day.getTimeInMillis();
		
		long remain = f_days - now_days;
		
		System.out.printf("종강까지 %d일\n", remain / (1000 * 60 * 60 * 24));
		
	}

}
