package day15;

/*
  이름을 입력받아서 입력한 이름이 한글이름인지를 검사하는 프로그램을 작성하라
  이름 글자수는 2글자에서 5글자까지만 허용하기로 한다.
 */

import java.util.*;
import java.util.regex.*;


public class Test03 {

	public Test03() {
		Scanner sc = new Scanner(System.in);
		
		//메세지 출력
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();
		/*
		   정규식 검사
		   		1. Pattern 클래스 이용해서 검사하고 싶은 정규식 문법을 만든다.
		   		
		   			이 클래스는 생성자가 감춰져 있는 경우이므로
		   			소속 함수 중 속성이 static이고 반환값 타입이 자기 자신 Pattern 타입인 함수를 찾아서 사용
		   			
		   			이 클래스는 new 시켜서 사용할 수 없는 클래스(생성자 감춰놨으니까)
		   			
		   		2. 이 클래스에게 정규식 문법을 검사해달라고 요청한다.
		   		
		   		   	검사하는 함수 : matcher()
		   		   	 			
		   		   	 			==> 검사 결과를 Matcher 클래스 타입으로 반환해준다.
		   		   	 				따라서 이 클래스 객체 내부에 모든 검사 결과가 기억되어 있다.
		   		   	
		   		   	검사 결과 꺼내오는 함수 : matches() // true or false로 반환
		 */
		   		   	
		
		//정규식 검사를 한다
		//1. 패턴을 정의한다
		Pattern form = Pattern.compile("[가-힣]{2,5}"); // 생성자가 private이라서 속성이 static이고 반환값이 자신인 함수 대신 쓴 것
		
		//2. 패턴에 맞는지 검사한다.
		Matcher mat = form.matcher(name);
		
		//3. 결과를 알아낸다.
		boolean bool = mat.matches();
		
		String result = bool ? "올바른" : "잘못된" ;
		
		//결과 출력
		System.out.println("입력받은 이름 [ " + name + " ] 은 " + result + " 이름입니다.");
	}
	
	public static void main(String[] args) {
		new Test03();
	}
	
}
		   		
		   		
		   		   	 			
		   		   	 
		   		
