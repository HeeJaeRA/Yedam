package ch11;

public class StringConvertExample {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String strData1 = "200";
		int intData1 = Integer.parseInt(strData1);

		System.out.println(intData1);
		
		int intData2 = 200;
		String strData2 = String.valueOf(intData2);
		
		System.out.println(strData2);
	}

}