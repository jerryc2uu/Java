package day18;
//하나의 프로그램 여러 번 실행 시 이를 구분하는 방법
public class Test11 {

	public Test11() {
		//1. 스레드 2개를 New Born 상태로 만든다
		NameThread t1 = new NameThread("리사");
		NameThread t2 = new NameThread();
		//하나의 클래스의 객체를 다른 방식으로 2개 만듦
		
		//2. Runnable로 전위
		t1.start();
		t2.start();
		
	}

	public static void main(String[] args) {
		new Test11();
	}

}


class NameThread extends Thread {
	/*
	  하나의 프로그램을 이용해서 여러 번 실행할 경우 
	  각 실행마다 그 이름을 구분할 필요가 생길 수 있다.
	  
	  구분할 수 있는 방법은 여러 가지가 있는데
	  
	  	1. 변수 하나를 만들고 그 변수에 값을 다르게 입력해서 구분하는 방법
	  		String name; (전역변수 셋팅 해놓고 new 시킬 때마다 다르게 셋팅)
	  		
	  	2. 스레드 프로그램 자체에 이름을 부여하는 방법
	  		이 때는 상위 클래스인 Thread의 Thread(String name) = 생성자 을 이용하면 된다.
	  		즉, 상위 클래스의 기본 생성자가 아닌 다른 생성자를 이용하면 스레드에 이름을 부여할 수 있게 된다.
	  		
	  		super();
	  		1) 반드시 생성자 안에서만 사용
	  		2) 첫 행 첫 문장으로만 사용
	  		
	  		상위 클래스의 생성자를 호출하는 방법 : super(); (생성자 함수 안의 첫 행 첫 문장으로)
	  		다른 클래스의 생성자를 호출하는 방법 : this();
	 */
	
	//기본 생성자
	public NameThread() {
		super("\t\t\tJennie");
		/*
		  이 방법은 여러 번 생성하더라도 항상 같은 이름일 것 
		
		 */
	}
	
	//생성자 함수
	public NameThread(String name) {
		super(name);//입력한 값으로 셋팅
		/*
		  new 시킬 때마다 입력된 이름으로 변경 가능
		 */
	}
	
	@Override
	public void run() {
		/*
		  스레드 이름 이용 방법
		  
		  	getName(); = 이름 알아내는 함수
		 	
		 	run()은 2번 실행될 것이다.
		 	그 때 순서를 무시한 병행 처리가 이루어질 것이다.
		 	현재 실행 중인 스레드가 어떤 스레드인지를 먼저 알아내야 한다.
		 	이 때 쓰는 함수가 currentThread();
		 	
		 */
		
		for(int i = 0 ; i < 1000 ; i++) {
			Thread t = Thread.currentThread();// static이고 반환값이 Thread라서 이렇게 씀
			String name = t.getName();//현재 실행 중인 스레드의 이름을 알아낸다.
			System.out.println(name + " 가 " + (i+1) + " 번째 노래를 합니다.");
		}
			
	}
}
	
	
	