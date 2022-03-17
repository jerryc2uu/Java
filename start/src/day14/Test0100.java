package day14;
/*
  	함수의 오버라이딩 규칙
  	1. 반환값, 이름, 매개변수 동일
  	2. 접근지정자 같거나 넓게
  	3. 예외 처리 같거나 좁게
 */
public class Test0100 extends Test0101{
	
	/*@Override
	void abc() throws Exception {
		System.out.println("전이하는 예외가 같은 경우는 상관 없다.");
	}
	*/
	@Override
	void abc() throws RuntimeException {
		System.out.println("범위가 좁아진 경우는 상관 없다.");
	}
	
	/*@Override
	void xyz() throws IllegalAccessException {
		System.out.println("전이하지 않은 예외로 바꾸면 안 된다.");
	}*/
	
	/*@Override
	void xyz() throws ArithmeticException, FileNotFoundException {
		System.out.println("전이하지 않은 예외는 추가하면 안 된다.");
	}
	 */
	void xyz() throws ArithmeticException, ClassCastException {
		System.out.println("RuntimeException 소속의 예외라 무시가 된다.");
	}
}

class Test0101 {
	void abc() throws Exception {
		System.out.println("#######################");
	}
	
	void xyz() throws ArithmeticException {
		System.out.println("***********************");
	}
}