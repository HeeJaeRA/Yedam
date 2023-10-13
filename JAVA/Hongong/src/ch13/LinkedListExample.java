package ch13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long start_time;
		long end_time;
		
		double sec;
		
		start_time = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		end_time = System.nanoTime();
		
		sec = ((double) end_time - start_time) / 100000000;
		
		System.out.println("ArrayList: " + sec + "초");
		
		
		start_time = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		end_time = System.nanoTime();
		
		sec = ((double) end_time - start_time) / 100000000;
		
		
		System.out.println("LinkedList: " + sec + "초");
		
	}

}
