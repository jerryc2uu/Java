package day13;

public class MinusAge extends Exception {

	/*
	   사용자 정의 예외 클래스 만드는 방법
	   
	   	1. Exception 클래스를 상속받은 클래스 만든다.
	   	2. toString()를 오버라이드 해서 예외 정보를 기술한다.
	   	
	 */
	
	@Override
	public String toString() {
		return getClass().getName() + " 음수의 나이가 입력되었습니다.";
			//실행되는 객체의 클래스를 가져오고, 그 클래스의 이름을 찾아내서 문자열로 반환해주는 함수
	}
}
