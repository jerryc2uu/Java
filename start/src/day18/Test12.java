package day18;
//스레드 번갈아가면서 실행하기 (Runnable 전위)
public class Test12 {

	public Test12() {
		//1. New Born 상태
		Jennie jn = new Jennie();
		Lisa ls = new Lisa();
		//2개의 클래스의 객체를 각각 하나씩 만듦
		
		//2. Runnable
		jn.start();
		ls.start();
	}

	public static void main(String[] args) {
		new Test12();
	}

}

class Jennie extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("Jennie가" + (i+1) +" 번째 노래를 합니다.");
			/*
			   한 곡을 노래했으니 다른 프로그램에게 양보하세요
			   즉, Runnable 상태로 전위하라는 뜻
			   yield();
			   
			 */
			yield();
		}
	}
}

class Lisa extends Thread {
	@Override
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("\t\t리사가" + (i+1) +" 번째 노래를 합니다.");
			yield();
		}
	}
}
		