package ping;
/*
 	이 클래스는 핑 서버 프로그램을 제어하는 클래스
 */
import java.util.*;
public class MainProc {

	public MainProc() {
		Scanner sc = new Scanner(System.in);
		//메세지 출력
		System.out.println("*** 핑 서버 프로그램 ***\n서버 기동 : start\n서버 중단 : quit\n명령을 입력하세요.");
		
		String str = sc.nextLine();
		switch(str) {
		case "start":
			new PingServer();
			break;
		case "quit":
			// 할 일 없음
			break;
		}
		
		
	}

	public static void main(String[] args) {
		new MainProc();
	}

}
