package day19;

public class Synch01 {
	//전역변수 만들기
	int[] num = new int[5]; // heap에 만들어지므로 0으로 자동초기화됨(기본 데이터 타입, 멤버 변수이므로)
	
	public Synch01() {
		//super();
		/* 따로 호출 안 해도 상위 클래스의 기본 생성자 호출된 상태	
		   
		   Object 클래스의 생성자 호출하는 함수 (따로 안 써도 감춰져 있는 것) 
			=> Object 클래스 new 시킨 것과 동일한 효과, 그래서 상위 클래스 멤버에 접근 가능한 것..
			
			this : new 시켜놓은 자신의 인스턴스 주소를 기억하는 예약된 변수
			
			super : 상위 클래스 인스턴스의 주소 기억하는 예약된 변수
		*/
		
		//1. New Born
		NumThread01 t1 = new NumThread01(this); // this 안 넣으면 Synch01의 num을 모르기 때문에 넣어줘야 한다. 
		NumThread02 t2 = new NumThread02(this); // this 안 넣으면 Synch01의 num을 모르기 때문에 넣어줘야 한다.
		
		//2. Runnable
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new Synch01();
	}

}

//num에 접근해서 데이터를 변경하는 스레드
class NumThread01 extends Thread {
	//위 클래스의 인스턴스 주소가 기억된 변수에 접근해서 num이라는 변수에 접근해야 한다.
	//이 안에서 Synch01 또 new 시키는 건 안 됨. 새로 인스턴스 만드는 거니까
	
	Synch01 main; // 넘겨주는 주소 받을 준비
	
	//기본 생성자
	public NumThread01() {}
	
	//주소 넘겨 받아서 이 클래스를 new 시킨다.
	public NumThread01(Synch01 main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		/*
		   이 스레드에서는 배열 변수에 데이터를 기억하는 역할을 할 예정
		   
		   이 스레드가 5개의 데이터를 완성(저장)할 때까지
		   다른 스레드(데이터 꺼내는)는 배열을 사용하지 못하게 하고 싶다면? 동기화 해준다
		 */
		System.out.println("### 이제 저장할 차례 ###");
		
		//동기화 해준다.
		synchronized(main.num) {
			for(int i = 0 ; i < 5 ; i++) {
				int no = (int)(Math.random()*99+1);// 1 ~ 99 사이의 랜덤한 정수 발생
				main.num[i] = no;
				// 출력
				System.out.println((i+1) + " 번째 방에 [ " + no + " ] 를 기억했습니다.");
				//잠시 쉬는 시간을 랜덤하게 준다 0.5 ~ 2초 사이로
 				int sec = (int)(Math.random()*1501+500);
 				
 				try {
 					Thread.sleep(sec);
 				} catch(Exception e) {
 			
 				}
			}
			System.out.println("\t***** 저장 완료 *****");
		}
		
	}
	
}

class NumThread02 extends Thread {
	Synch01 main; // Synch01의 주소를 기억할 준비
	
	public NumThread02() {}

	public NumThread02(Synch01 main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		//이 스레드는 배열 변수의 데이터를 꺼내서 사용하는 역할을 할 예정
		System.out.println("\t\t\t이제 사용할 차례...");
		synchronized(main.num) {
			//여기서 main의 num 배열을 사용하는 동안은 다른 곳에서 배열을 사용하면 안 된다.
			for(int i = 0 ; i < 5 ; i++) {
				int no = main.num[i];
				//숫자 꺼냈으므로 출력
				System.out.println("\t\t\t*** " + no + " 를 사용했습니다.");
				//쉬는 시간을 랜덤하게 정할 예정이고 (0.5 -2 초 )
				int sec = (int)(Math.random()*1501+500);
				
				try {
					Thread.sleep(sec);
				} catch(Exception e) {
					
				}
				
			}
			System.out.println("\t\t\t@@@@@@@@@@ 사용 종료 @@@@@@@@@@@@");
		}
	}
	
}
