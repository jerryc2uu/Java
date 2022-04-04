package ping;
import java.util.*;

public class Exce01 {

	public Exce01() {
		boolean bool = true;
		Scanner sc = new Scanner(System.in);
		
		PingServer02 t1 = new PingServer02();
		
		while(bool) {
			

		//메세지 출력
		System.out.println("*** 핑 서버 프로그램 ***\n서버 기동 : start\n서버 중단 : quit\n명령을 입력하세요.");
		String str = sc.nextLine();
			
		
			
		switch(str) {
		case "start":
			if(t1.isStart()) {
			t1.start();
			}
			break;
		case "quit":
			bool = false;
			t1.setStart(false);
			break;
		
		}
		}
	}

	public static void main(String[] args) {
		new Exce01();
	}

}
