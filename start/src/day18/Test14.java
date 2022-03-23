package day18;
// stop();으로 Run -> Death 전위
public class Test14 {

	public Test14() {
		
		//1. New Born
		EndClass ecls = new EndClass();
		
		//2. Runnable
		ecls.start();
		
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("메인 실행 중..."+ (i+1));
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
		//위 명령이 모두 실행이 끝나면 메인 내용이 완료되었으므로
		//스레드도 종료시켜보자.
		
		//3. Death로 전위
		ecls.stop();//deplecated 함수라는 뜻.. 안 쓰는 게 좋다. 
					//조건식에 제어 변수를 만들어서 자연스럽게 종료시키는 게 좋다. 
					//생성자에서 스레드 종료하는 명령해놨음
	}

	public static void main(String[] args) {
		new Test14();
		System.out.println("####프로그램 종료####");
	}

}

class EndClass extends Thread {
	
	@Override
	public void run() {
		for(int i = 0 ; i < 50 ; i++) {
			System.out.println("\t\t스레드 실행 중입니다." + (i+1));
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				
			}
		}
	}


}


