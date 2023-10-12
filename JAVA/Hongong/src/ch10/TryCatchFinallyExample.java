package ch10;

public class TryCatchFinallyExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String data1 = null;
		String data2 = null;
		
		try {
			data1 = args[0];
			data2 = args[1];
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.printf("%d + %d = %d\n",value1, value2, result);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환 할 수 없습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
		
	}

}
