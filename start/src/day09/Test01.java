package day09;

public class Test01 {//자바에서는 클래스 단위로 프로그래밍 해야 함. 클래스가 코딩의 기본 단위
	
	private int no = 10;// Test01 클래스 내에서만 사용 가능
	
	int num = 1000;
	// abc라는 이름의 함수
	static void abc(int no) {// 이 함수를 실행하려면 int 타입의 데이터 하나를 반드시 입력해야 함
		
	}

	public static void main(String[] args) {
		abc(10);  //==>  스태틱 영역에 먼저 올려질 때 abc라는 함수가 없음, 그래서 윗줄에서 스태틱을 붙여줌
		                  //(스태틱이 붙으면 스태틱이라는 메모리 영역에 먼저 올려짐)

	}
	
	void xyz() {//2가지 함수에 변수 하나를 가진다. 뭔가 기능이 필요할 땐 함수를 제작한다.
		int no = 10;
		System.out.println();
		abc(no);//같은 코드가 반복되거나 전체 구조를 파악하기 어려우면 함수로 따로 빼는 게 유리
	}
	
	// 1, "숫자 : " ==> "숫자 : 1" 바꿔주는 함수가 있다고 가정
	public String add(int no, String str) {//add("abc : ", 10); -> 순서가 달라서 안됨 add(10, "abc : ") -> 올바른 형태
		String result = str + no;
		return result;
	}
	
	/*
	  Test01 t1 = new Test01();
	  int num = t1.no;  // Test01의 변수에 접근 
	 */
	
}


class Test01_01 {
	
	public void abc() {
		
		Test01 t1 = new Test01();
		//int num = t1.no; // 클래스가 다르기 때문에 no 변수에 접근 불가능
		int num2 = t1.num; // 생략되었기에 같은 패키지 소속 클래스끼리 사용 가능
	}
}