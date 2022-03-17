package day05.ex;
/*
1바이트(0이나 1을 8개 만들라)로 기억되는 2진수를 랜덤하게 만들어
그 숫자가 10진수로 몇인지 출력하는 프로그램을 작성하세요

참고 ] 
  문자열 2진수를 10진수 정수로 변환해주는 방법
  
  Integer.valueOf("문자열 2진수", 2);    (8진수, 8)  (16진수, 16)
  Integer.parseInt("문자열 2진수", 2);
  
*/
public class Ex08_01 {

	public static void main(String[] args) {
		// 이진수 기억할 변수 만들기
		String bno = "";
		
		// 반복해서 0 또는 1을 만들어서 위 변수의 왼쪽에 덧붙여준다.
		for (int i = 0 ; i < 8 ; i++) {
			int no = (int)(Math.random() * 2);
			
			//이진수 변수에 덧붙인다.
			bno = no + bno;
		}
		
		//문자열 형태의 2진수를 10진수로 변환해준다.
		int num = Integer.valueOf(bno, 2);
		
		//출력
		System.out.println("랜덤하게 만들어진 이진수 : " + bno);
		System.out.println("10진수로 변환한 2진수 : " + num);
			
	}
		
}
		
		


