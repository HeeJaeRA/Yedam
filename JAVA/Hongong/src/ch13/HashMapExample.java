package ch13;

import java.util.*;

public class HashMapExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
//		Map<String, Integer> map = new HashMap<>();
//		
//		boolean run = true;
//		
//		map.put("신용권", 85);
//		map.put("홍길동", 90);
//		map.put("동장군", 80);
//		map.put("홍길동", 95);
//		
//		while (run) {
//			Scanner sc = new Scanner(System.in);
//
//			System.out.println("----------------------------------------------------------------");
//			System.out.println("1. 전체 조회 2. 개별 조회 3. 전체 삭제 4. 개별 삭제 5. 자료 입력 6. 종료");
//			System.out.println("----------------------------------------------------------------");
//			System.out.print("선택> ");
//			int selnum = sc.nextInt();
//			
//			switch (selnum) {
//			
//			case 1:
//				Set<String> keySet = map.keySet();
//				Iterator<String> keyIterator = keySet.iterator();
//				
//				while(keyIterator.hasNext()) {
//					String key = keyIterator.next();
//					Integer val = map.get(key);
//					System.out.println("\t"+ key + ": " + val);
//				}
//				System.out.println("총 Entry: " + map.size());
//				System.out.println();
//				break;
//				
//			case 2:
//				System.out.print("조회할 이름> ");
//				String s_key = sc.next();
//				System.out.printf("%s: %s\n", s_key, map.get(s_key));
//				System.out.println();
//				break;
//				
//			case 3:
//				map.clear();
//				System.out.println("전체 삭제");
//				System.out.println("총 Entry: " + map.size());
//				System.out.println();
//				break;
//				
//			case 4:
//				System.out.print("삭제할 이름> ");
//				String d_key = sc.next();
//				map.remove(d_key);
//				System.out.printf("%s 삭제", d_key);
//				System.out.println();
//				break;
//				
//			case 5:
//				System.out.print("이름> ");
//				String m_key = sc.next();				
//				System.out.print("점수> ");
//				Integer m_val = sc.nextInt();
//				map.put(m_key, m_val);
//				System.out.println(m_key + " 추가 완료");
//				System.out.println();
//				break;
//				
//			case 6:
//				run = false;
//				break;
//				
//			default:
//				System.out.println("다시 입력");
//			}
//			
//		}
//		
//		System.out.println();
//		
//		Map<Student, Integer> map_1 = new HashMap<>();
//		
//		map_1.put(new Student(1, "홍길동"), 90);
//		map_1.put(new Student(2, "길동홍"), 80);
//		map_1.put(new Student(3, "동홍길"), 60);
//		map_1.put(new Student(1, "홍길동"), 95);
//		
//		Set<Student> keySet_1 = map_1.keySet();
//		Iterator<Student> keyIterator_1 = keySet_1.iterator();
//		while(keyIterator_1.hasNext()) {
//			Student key_1 = keyIterator_1.next();
//			Integer val_1 = map_1.get(key_1);
//			System.out.println(key_1.studentNum + "." + key_1.name + ": " + val_1);
//		}
//		System.out.println();
//
//		System.out.println("총 Entry: " + map_1.size());
		
		Map<String, Integer> map_2 = new HashMap<>();
		
		map_2.put("blue", 96);
		map_2.put("hong", 86);
		map_2.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Set<String> keySet_2 = map_2.keySet();
		Iterator<String> keyIterator_2 = keySet_2.iterator();
		
		while(keyIterator_2.hasNext()) {
			String key_2 = keyIterator_2.next();
			Integer val_2 = map_2.get(key_2);
			if (maxScore < val_2) {
				name = key_2;
				maxScore = val_2;
			}
			totalScore += val_2;
		}
		System.out.println("평균 점수: " + totalScore / map_2.size());
		System.out.println("최고 점수: " + maxScore);
		System.out.println("최고 점수를 받은 아이디: " + name);
		
	}

}
