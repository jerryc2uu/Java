package day18;
//sleep(시간); 으로 Run -> Block 전위
public class Test13 {

	public Test13() {
		//1. new
		Sky sky = new Sky();
		Yh yh = new Yh();
		
		//2. New Born
		Thread t1 = new Thread(sky);
		Thread t2 = new Thread(yh);
		
		//3. Runnable
		t1.start();
		t2.start();
		
	}

	public static void main(String[] args) {
		new Test13();
	}

}

class Sky implements Runnable {

	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("하늘씨가 자바를 " + (i+1) + " 번째 코딩합니다.");
			//한 번 출력하면 아예 Block 상태로 보낸다.
			//복귀 시간 정해서
			try {
				Thread.sleep(1000); //복귀시간은 1초 밀리 세컨즈 단위, sleep() : 예외 전이 함수
			} catch(Exception e) {
				
			}
			
		}
	}
	
}

class Yh implements Runnable {

	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println("\t\t용현씨가 " + (i+1) + " 번째 복습을 합니다.");
			try {
				Thread.sleep(1000); // 1초 후 Block => Runnable로 전위
			} catch(Exception e) {
				
			}
		}
	}
	
}