package day17;
//Scanner 이용해서 읽어보자
import java.io.*;

import java.util.*;
public class Test06 {

	/*
	   우리가 이제까지 키보드로 입력받을 때 사용했던 클래스는 Scanner 클래스
	   
	   생성 방법 : Scanner sc = new Scanner(InputStream in)  // Scanner 클래스의 생성자 함수
	                                
	   Scanner(System.in) : System 클래스 안에 있는 static 멤버(new 안 시켜도 사용 가능) in이라는 변수(InputStream), 
	   
	   Scanner는 장치에 연결하는 클래스 (키보드뿐 아니라 파일에도 연결 가능)
	   
	   Scanner(File file) : 스캐너로 파일 내용을 직접 읽어올 수도 있다!
	   
	 */
	public Test06() {
		
		//File 준비
		File file = new File("src/day17/result/FileTest01.txt");//추상클래스나 생성자가 private인 클래스는 new 불가, static 반환값이 자신인 함수 호출
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			
			/*
			//한 단어만 읽어서 출력
			String str = sc.next();//한 글자만 뽑아내는 함수
			*/
			//한 행을 읽어서 출력
			String str = sc.nextLine();//한 행 전체 읽는 함수
			System.out.println(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test06();
	}

}
