package ch11;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO 자동 생성된 메소드 스텁
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes();
		System.out.println("길이: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println(str1);
		
		System.out.println();
		
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println("길이: " + bytes2.length);
		String str2 = new String(bytes2, "EUC-KR");
		System.out.println(str2);
		
		System.out.println();
		
		byte[] bytes3 = str.getBytes("UTF-8");
		System.out.println("길이: " + bytes3.length);
		String str3 = new String(bytes3, "UTF-8");
		System.out.println(str3);

	}

}
