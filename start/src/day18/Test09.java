package day18;
/*
   스레드 프로그램을 실행해보자
   
	   1. 스레드 프로그램은 반드시 New Born 상태로 만들어야 한다.
	   		= 실행 가능한 프로그램으로 만들라는 의미
	   		= 자바에서는 new 시키라는 것 	
 */
public class Test09 {

	public Test09() {
		
		//1. New Born 상태
		MyThread01 jy = new MyThread01(); 
		MyThread02 sw = new MyThread02(); 
		//이것을 실행하려면 스레드 프로그램이 Runnable 상태로 전위되어야 한다.
		
		//2. New Born => Runnable 상태 : start();
		jy.start();
		sw.start();
		
		System.out.println("===============생성자 쪽 종료=============="); 

		
		
		
		
	}

	public static void main(String[] args) {
		new Test09();
		System.out.println("##############메인 함수 종료################"); 
	}

}

/*
   본래 스레드 프로그램 역시 다른 파일에 클래스를 만들어야 하는데 
   임시로 하나의 클래스 내에 만들기로 한다. 
 */

//1. 스레드 클래스 상속받아서 만드는 법
class MyThread01 extends Thread {
	//이 클래스 내에는 변수나 함수를 만들 수 있지만
	//여기서는 테스트만 해보기로 한다.
	
	@Override
	public void run() {
		// 나는 이 프로그램에서 주연이가 코딩을 1000개를 하도록 하게 할 것이다.
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("*** 주연이가 코딩을 합니다 : " + (i+1 + " 회차"));//괄호 필수
			
		}
	}
}

class MyThread02 extends Thread {
	@Override
	public void run() {
		// 선우가 스트레칭을 1000번 합니다.
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("\t\t\t*** 선우가 " + (i+1) +" 번째 스트레칭을 합니다.");//탭키
		}
	}
}