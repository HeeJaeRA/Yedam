package ch5;

import java.util.Calendar;

public class Exam210p {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
//		System.out.println(cal);
		
		Week week = null;
		
		int today = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (today) {
		
		case 1: week = Week.일요일; break;
		case 2: week = Week.월요일; break;
		case 3: week = Week.화요일; break;
		case 4: week = Week.수요일; break;
		case 5: week = Week.목요일; break;
		case 6: week = Week.금요일; break;
		case 7: week = Week.토요일; break;
		
		}
		
		System.out.println(week);
		
		if (week == Week.일요일) {
			System.out.println("축구");
		} else {
			System.out.println("자바");
		}
		
		LoginResult result = LoginResult.FAIL_PASSWORD;
		
		if (result == LoginResult.SUCCESS) {
			System.out.println("로그인 성공");
		} else if (result == LoginResult.FAIL_ID) {
			System.out.println("ID 오류");
		} else if (result == LoginResult.FAIL_PASSWORD) {
			System.out.println("Password 오류");
		}
	}

}
