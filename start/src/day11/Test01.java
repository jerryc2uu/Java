package day11;

public class Test01 {
	int no1 = 10; // 1. 명시적 초기화
	
	
	
	int no2;
	// no2 = 100; (x)  클래스 블럭 바로 아래에는 일반 명령이 올 수 없음
	{
		no1 = 1;
		no2 = 100; // 2. 초기화 블럭을 이용한 초기화
	}
	
	public Test01() {
		System.out.println(no1);// 1 -> 2 순서이기 때문에 2의 값을 기억함.
	}
	public static void main(String[] args) {
		new Test01();

	}

}
