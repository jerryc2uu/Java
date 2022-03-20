package day13;

public class Test02 {
	
	public Test02() {
		/*
		   이 안에서 필요한 작업을 기술
		   왜냐하면 생성자 함수는 new 명령과 함께 호출하고 
		   인스턴스가 만들어지게 되므로 this가 생겨나고
		   이 함수 안에서는 아무런 제약 없이 모든 멤버를 사용할 수 있기 때문
		 
		   ==> 생성자 함수 안에서는 모든 멤버에 접근 가능하다는 뜻
		 */
		int a = 0;
		int b = 25;
		int c = 0;
		
		//세 수를 이용해서 산술 연산을 하게 되는 경우 
		//어떤 상황에서 예외가 발생할지 개발자가 모두 알고 있어야 한다.
		if(a != 0) {
			c = b / a;
		} else {
			//사용자가 데이터를 잘못 입력한 경우
			//개발자가 그 잘못을 수정해서 처리해야 한다.
			c = b;
		}
		
		System.out.println("결과 : " + c);
	}
	
	public static void main(String[] args) {
		new Test02();

	}	

}
