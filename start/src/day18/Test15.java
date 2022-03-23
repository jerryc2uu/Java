package day18;
//stop(); 쓰지 말고 변수를 조작해서 스레드 프로그램 자연스럽게 종료시키기
public class Test15 {

	public Test15() {
		
		Jin jin = new Jin(); //New Born 상태
		jin.start(); //Runnable 상태
		
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println("\t\t*** 선생님이 졸고 있습니다.");
			try {
				Thread.sleep(200);
			} catch(Exception e) {
				
			}
		}
		// jin. stop(); deplecated 함수이므로 자연스럽게 스레드 프로그램을 종료시켜본다.
		jin.setStart(false);//이 함수 호출하는 순간 isStart가 false로 바뀐다.
	}

	
	
	public static void main(String[] args) {
		new Test15();
	}

}

class Jin extends Thread {
	private boolean isStart = true;
	
	@Override
	public void run() {
		while(isStart) {
			System.out.println("### 서진씨가 복습합니다.");
			try {
				Thread.sleep(200);
			} catch(Exception e) {
				
			}
		}
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	
}




