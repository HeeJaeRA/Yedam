import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class DateExample {
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		LocalDate now = LocalDate.now();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("현재 연도> ");
		int year = Integer.parseInt(sc.nextLine());
		
		
		System.out.print("현재 월> ");
		int mon = Integer.parseInt(sc.nextLine());
				
//		LocalDate date = now.withYear(2023);
//		date = date.withMonth(12);
//		date = date.withDayOfMonth(1);
		
		LocalDate date = now.withYear(year);
		date = date.withMonth(mon);
		
		System.out.printf("\t\t%d년 %d월\n", date.getYear(), date.getMonthValue());
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		cal.set(date.getYear(), date.getMonthValue() - 1, 1);
		
		int start = cal.get(Calendar.DAY_OF_WEEK);
		
		for (int i = 1; i < start; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%d\t", i);
			start++;
			if (start % 7 == 1) {
				System.out.println();
			}
		}
	
	}
}
