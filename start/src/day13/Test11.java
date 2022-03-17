package day13;

/*
   blackpink.txt. 파일을 읽어서 출력해보자

 */

import java.io.*;//input output 장치 관련 패키지

public class Test11 {

	public Test11() {
		
		FileInputStream fis = null; // 외부 장치(파일)에 연결하는 관 역할하는 클래스
		
		try {
			
			fis = new FileInputStream("src/day13/blackpink.txt");
			
			//나중에 배울 내용이니 스킵
			byte[] buff = new byte[1024];
			int len = fis.read(buff);
			String str = new String(buff, 0, len);
			System.out.println(str);
			
		} catch(Exception e) {
			
			System.out.println("####예외 발생####");
		}
		
	}

	public static void main(String[] args) {
		new Test11();
	}

}
