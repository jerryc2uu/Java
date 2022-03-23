package day18;

/*
 	2. Runnable 인터페이스 구현한 스레드 프로그램 실행 방법
	
		1)	new 시킨다.		==>	일반 클래스를 사용하기 위한 객체지향 방법 (New Born 상태 아님)
		2)	Thread 클래스를 new시키면서 1)의 결과를 넣어준다.
			==>		이순간 New Born이 된다.
		3)	2)의 결과를 이용해서 start 시킨다.
			==>		이순간 Runnable  상태로 전위된다.
 */
 	
public class Test10 {

	public Test10() {
		// Runnable 인터페이스 구현한 스레드 프로그램 실행하는 방법
		
		//1. new 시킨다.
		Yuna yuna = new Yuna();
		Euns euns = new Euns();//아직 두 프로그램은 New Born 상태가 아님
		
		//2. New Born 상태로 만들어 준다.
		Thread t1 = new Thread(yuna);
		Thread t2 = new Thread(euns);
		
		//3.Runnable 상태로 전위
		t1.start();
		t2.start();
		
		
		
	}

	public static void main(String[] args) {
		new Test10();
	}

}

class Yuna implements Runnable {
	
	@Override
	public void run() {
		quest();
	}
	
	public void quest() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("*** io 유나씨가" + (i + 1) + " 번째 질문을 합니다.");
		}
	}
	
}

class Euns implements Runnable {

	@Override
	public void run() {
		answer();
	}
	
	public void answer() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("\t\t\t### 선생님이 " + (i + 1) + " 번째 대답을 합니다.");
		}
	}
	
}
